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


    let customer = {
        customerID:"C001",
        name:name,
        address:address,
        email:email,
        licenseNo:nic,
        frontImage:nicFornt,
        backImage:nicBack,
        username:username
    }

    $.ajax({
        url : mainLink + 'customer',
        method : "post",
        data : JSON.stringify(customer),
        contentType : 'application/json',
        success:function(){
            console.log("Success")
        },
        error : function(){
            console.log("Error")
        }
    });

}