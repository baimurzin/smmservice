<#import "parts/base.ftl" as base>
<@base.layout>

    <#include "parts/navbar.ftl">


    <main class="content static">
        <div class="home-title__wrap">
            <h1 class="home-title">Уроки школьной программы</h1>
            <p class="home-title_small">Видео, конспекты, тесты, тренажеры</p>
        </div>
        <div class="home-tabs">
            <div id="ember7303" class="ember-view">
                <div class="subjects active">
                    <div class="subjects__menu row justify-content-around">
                        <div class="subjects__col">
                            <ul class="subjects__list ">
                                <#list groups as group >
                                    <li id="ember7308" class="subjects__tab subjects__tab_engineering ember-view">
                                        <a href="#" id="ember7309" class="index_icon subjects__tab-link ember-view">
                                            <#if group?is_sequence>
                                              <#list group as c>
                                                  ${c}
                                              </#list>
                                            <#elseif group?is_hash_ex>
                                                <#list group?keys as key>
                                                    ${key} - ${group[key]}
                                                </#list>
                                            </#if>
                                        </a>
                                    </li>
                                </#list>

                            </ul>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </main>
</@base.layout>