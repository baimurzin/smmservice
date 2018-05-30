package com.smm;

import com.smm.configuration.AppConfig;
import com.smm.model.Order;
import com.smm.model.PaymentDetail;
import com.smm.model.PaymentType;
import com.smm.service.OrderService;
import com.smm.service.SmmService;
import com.smm.vendor.payment.PayStrategy;
import com.smm.vendor.payment.PayStrategyFactory;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = AppConfig.class)
public class SmmserviceApplicationTests {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private OrderService orderService;

	@Autowired
	private SmmService smmService;

	@Test
	public void testPayWithRobokassaPaymentProvider() {
		PaymentDetail paymentDetail = new PaymentDetail();
		paymentDetail.setPaymentProvider(PaymentType.ROBOKASSA);
		orderService.checkoutOrder(paymentDetail);
	}

	@Test
	public void testPayWithPayPalPaymentProvider() {
		PaymentDetail paymentDetail = new PaymentDetail();
		paymentDetail.setPaymentProvider(PaymentType.PAYPAL);
		orderService.checkoutOrder(paymentDetail);
	}

	@Test
	public void testPayWithUnknownPaymentProvider() {
		thrown.expect(UnsupportedOperationException.class);
		PaymentDetail paymentDetail = new PaymentDetail();
		orderService.checkoutOrder(paymentDetail);
	}

	@Test
	public void testSmmLabaAPIProvider() {
		smmService.addOrder(new Order());
	}

}
