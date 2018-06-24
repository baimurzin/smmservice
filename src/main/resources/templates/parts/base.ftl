<#macro layout>

<!DOCTYPE html>
<!-- saved from url=(0018)https://egeege.ru/ -->
<html lang="ru">

<#include "header.ftl">

<body class="vsc-initialized">
<div class="wrapper__column">
    <#include "header_logo.ftl">
    <div class="container">
        <#nested>
    </div>
</div>
</body>

<#include "footer.ftl">

</html>
</#macro>