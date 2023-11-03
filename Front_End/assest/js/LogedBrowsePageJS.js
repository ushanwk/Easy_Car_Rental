var username = localStorage.getItem("username");

$('#txtLogedName').text(username);

$.ajax({
    url: `http://localhost:8080/Back_End_war/customer?username=${username}`,
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let customer = resp.data;
        $('#txtLogedName').text(customer.name);

    },
    error: function (ob, statusText, error) {

    }
});