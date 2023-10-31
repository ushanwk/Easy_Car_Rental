$('#step1').show();
$('#step2').hide();
$('#step3').hide();

$('#btnNext1').click(function (){
    $('#step1').hide();
    $('#step2').show();
    $('#step3').hide();
});

$('#btnNext2').click(function (){
    $('#step1').hide();
    $('#step2').hide();
    $('#step3').show();
});

generateCustomerID()

$('#btnReg').click(function () {
    addCustomer();
});

let mainLink = "http://localhost:8080/Back_End_war/";

function addCustomer(){

    let name = $('#inputName').val();
    let address = $('#inputAddress').val();
    let email = $('#inputEmail').val();
    let nic = $('#inputNic').val();
    let nicFornt = $('#inputNicFront').val();
    let nicBack = $('#inputNicBack').val();
    let username = $('#inputUsername').val();
    let password = $('#inputPassword').val();


    let customer = {
        customerID:username,
        name:name,
        address:address,
        email:email,
        nicNo:nic,
        frontImage:nicFornt,
        backImage:nicBack,
        username:username,
        user:{
            username:username,
            password:password,
            role:"CUSTOMER"
        }
    }

    $.ajax({
        url : mainLink + 'customer',
        method : "post",
        data : JSON.stringify(customer),
        contentType : 'application/json',
        success:function(){
            console.log("Success")
            saveCustomerImages();
        },
        error : function(){
            console.log("Error")
        }
    });





}


function saveCustomerImages(){
    let formData = new FormData($('#imagesCus')[0]);

    $.ajax({
        url : mainLink + 'customer?customerId=' + "C001",
        method : "post",
        sync:true,
        data : formData,
        processData: false,
        contentType: false,
        success:function(){
            console.log("Image Added Success")
        },
        error : function(){
            console.log("Error")
        }
    });
}



function generateCustomerID() {
    $("#txtCusID").text("C00-001");
    $.ajax({
        url: "http://localhost:8080/Back_End_war/customer/IdGenerate",
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (resp) {
            let id = resp.value;
            console.log("id" + id);
            let tempId = parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                $("#txtCusID").text("C00-00" + tempId);
            } else if (tempId <= 99) {
                $("#txtCusID").text("C00-0" + tempId);
            } else {
                $("#txtCusID").text("C00-" + tempId);
            }
        },
        error: function (ob, statusText, error) {
            resp.message();
        }
    });
}