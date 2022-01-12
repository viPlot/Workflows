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
    <form action="/login" method="post">
        <div><label>User Name: <input name="email" placeholder="Почта"/></label></div>
        <div><label>Password:<input name="password" type="Пароль"/></label></div>
        <input type="hidden" name="_csrf" value="{{_csrf.token}}"/>
        <div><input type="submit" value="Sign In"></div>
    </form>
</div>
</body>
</html>