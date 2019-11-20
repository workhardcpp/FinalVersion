<body>
<h2>${message}</h2>
<form action="/update">
    <table>
        <caption>
            <h3>Enter Your Login Credentials</h3>
        </caption>
        <tr>
            <td>User Name</td>
            <td><input type="text" id="name"></input></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" id="password"></input></td>
        </tr>
        <tr rowspan="2">
            <td><input type="submit"></input></td>
        </tr>
    </table>
</form>