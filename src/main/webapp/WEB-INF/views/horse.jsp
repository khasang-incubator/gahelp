<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<script>
    var service = 'http://localhost:8080/horse'

    var RestGetAll = function () {
        $.ajax({
            type: 'GET',
            url: service + '/all',
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }

        });
    };

    var RestGet = function (id) {
        $.ajax({
            type: 'GET',
            url: service + '/get/' + id,
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }

        });
    };



    var RestPost = function (name, description) {
        var JSONObject = {
            'name': name,
            'description': description
        };

        $.ajax({
            type: 'POST',
            url: service + '/add',
            dataType: 'json',
            data: JSON.stringify(JSONObject),
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestDelete = function (id) {
        $.ajax({
            type: 'DELETE',
            url: service + '/delete/' + id,
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestUpdate = function (id, name, description) {
        var JSONObject = {
            'name': name,
            'description': description
        };

        $.ajax({
            type: 'PUT',
            url: service + '/update/' + id,
            dataType: 'json',
            data: JSON.stringify(JSONObject),
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };
</script>

<body>
<h1>Horse API</h1>

<table class="table">
    <tr>
        <th>Request type</th>
        <th>URL</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>Get all horses - <code><strong>GET</strong></code></td>
        <td>/horse/all</td>
        <td>
            <button type="button" onclick="RestGetAll()">try</button>
        </td>
    </tr>
    <tr>
        <td>Get horse by id - <code><strong>GET</strong></code></td>
        <td>/horse/get/{id}</td>
        <td>
            id: <input id="getHorseByID" value="1"/>
            <button type="button" onclick="RestGet($('#getHorseByID').val())">try</button>
        </td>
    </tr>
    <tr>
        <td>Add new horse - <code><strong>POST</strong></code></td>
        <td>/horse/add</td>
        <td>
            name: <input id="horseName" value="Risak"/>
            description: <input id="horseDescription" value="fast"/>
            <button type="button" onclick="RestPost($('#horseName').val(), $('#horseDescription').val())">try</button>
        </td>
    </tr>
    <tr>
        <td>Delete horse by id - <code><strong>DELETE</strong></code></td>
        <td>/horse/delete/{id}</td>
        <td>
            id: <input id="deleteHorseByID" value="1"/>
            <button type="button" onclick="RestDelete($('#deleteHorseByID').val())">try</button>
        </td>
    </tr>
    <tr>
        <td>Update horse - <code><strong>PUT</strong></code></td>
        <td>/horse/update</td>
        <td>
            id: <input id="updatedHorseId" value="1"/>
            name: <input id="updatedHorseName" value="Max"/>
            description: <input id="updatedHorseDescription" value="fast"/>
            <button type="button" onclick="RestUpdate($('#updatedHorseId').val(), $('#updatedHorseName').val(), $('#updatedHorseDescription').val())">try</button>
        </td>
    </tr>
</table>

<div class="panel panel-default">
    <div class="page-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response"></div>
</div>

</body>
</html>
