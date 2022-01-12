<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="{{_csrf.token}}"/>
        <input type="submit" value="Sign out"/>
    </form>
</div>
<h3>Assigment list</h3>
<div>
    <table>
        <tr>
            <th>Name</th>
            <th>Status</th>
            <th>Creator id</th>
            <th>Document</th>
        </tr>
        <#list assignments as assignment>
            <td>${assignment.name}</td>
            <td>${assignment.status}</td>
            <td>${assignment.idCreator}</td>
            <td>${assignment.isDocument}</td>
        </#list>
    </table>
</div>
</body>
</html>