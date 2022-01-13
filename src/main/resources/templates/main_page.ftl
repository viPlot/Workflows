<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>

<div>Assigment list</div>
<#list assignments as assignment>
<div>
    <b>${assignment.name}</b>
    <span>${assignment.status}</span>
    <i>${assignment.idCreator}</i>
    <i>${assignment.isDocument}</i>
</div>
<#else>
No assignments
</#list>
</@c.page>