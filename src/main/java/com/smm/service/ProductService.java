package com.smm.service;

import com.smm.model.Param;
import com.smm.model.Service;
import com.smm.model.ServiceGroup;
import com.smm.model.ServiceProduct;
import com.smm.model.enums.ServiceType;
import com.smm.repository.ParamRepository;
import com.smm.repository.ServiceGroupRepository;
import com.smm.repository.ServiceProductRepository;
import com.smm.repository.ServiceRepository;
import com.smm.vendor.smm.SMMAPIStrategy;
import com.smm.vendor.smm.impl.smmlaba.APIResponse;
import com.smm.vendor.smm.impl.smmlaba.APIResponseMessageList;
import com.smm.vendor.smm.impl.smmlaba.messages.APIMessageServices;
import com.smm.vendor.smm.impl.smmlaba.messages.APIMessageServicesPrices;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang.StringUtils.*;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ProductService {

    private final SMMAPIStrategy<APIResponse, APIResponseMessageList> smmApiStrategy;

    private final ServiceGroupRepository serviceGroupRepository;

    private final ServiceRepository serviceRepository;

    private final ServiceProductRepository serviceProductRepository;

    private final ParamRepository paramRepository;


    private final String CATEGORY_DELIMITER = ". ";


    public void updateProducts() {
        APIResponseMessageList<APIMessageServices> services = smmApiStrategy.getServices();
        //todo remove
        if (!services.getMessage().isEmpty()) {
            serviceProductRepository.truncateTable();
            serviceRepository.truncateTable();
            serviceGroupRepository.truncateTable();
        }
        Map<String, ServiceGroup> serviceGroups = new HashMap<>();
        List<Service> resultServices = new ArrayList<>();
        List<ServiceProduct> serviceProducts = new ArrayList<>();
        List<Param> params = new ArrayList<>();

        for (APIMessageServices messages : services.getMessage()) {
            String category = messages.getCategory().toLowerCase();
            String[] categorySplit = category.split(CATEGORY_DELIMITER);

            String serviceGroupName = categorySplit[0];

            if (!ServiceType.hasService(serviceGroupName)) {
                continue;
            }

            String serviceName = null;
            if (categorySplit.length > 1) {
                serviceName = categorySplit[1].replaceAll(serviceGroupName, "").trim();
            }
            String productName = messages.getProductName().toLowerCase()
                    .replaceAll("\\(.*\\)", "")
                    .replaceAll(serviceGroupName, "")
                    .replaceAll("акция!", "")
                    .replaceAll("-", "")
                    .trim();

            if(serviceName != null && !containCyrillic(serviceName)) {
                productName = productName.replaceAll(serviceName, "")
                        .trim();
            }

            List<Param> tmpParams = new ArrayList<>();
            for (APIMessageServicesPrices param : messages.getParams()) {
                tmpParams.add(Param.builder()
                        .name(param.getName())
                        .required(param.getRequired())
                        .validationRule(param.getValid())
                        .paramName(param.getParam())
                        .build());
            }

            ServiceGroup sg = ServiceGroup.builder()
                    .name(capitalize(serviceGroupName))
                    .build();

            serviceGroups.putIfAbsent(sg.getName(), sg);


            Service service = Service.builder()
                    .name(capitalize(serviceName))
                    .serviceGroup(serviceGroups.get(sg.getName()))
                    .build();


            ServiceProduct serviceProduct = ServiceProduct.builder()
                    .name(capitalize(productName))
                    .price(messages.getPrice())
                    .service(service)
                    .apiServiceId(messages.getService())
                    .build();

            tmpParams.forEach(p -> p.setServiceProduct(serviceProduct));

            resultServices.add(service);
            params.addAll(tmpParams);
            serviceProducts.add(serviceProduct);


        }
        serviceGroupRepository.saveAll(serviceGroups.values());
        serviceRepository.saveAll(resultServices);
        serviceProductRepository.saveAll(serviceProducts);
        paramRepository.saveAll(params);
    }


    private boolean containCyrillic(String text) {
        for(int i = 0; i < text.length(); i++) {
            if(Character.UnicodeBlock.of(text.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC)) {
                return true;
            }
        }
        return false;
    }
}
