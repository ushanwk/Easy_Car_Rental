document.addEventListener("DOMContentLoaded", function(event) {

    const showNavbar = (toggleId, navId, bodyId, headerId) =>{
        const toggle = document.getElementById(toggleId),
            nav = document.getElementById(navId),
            bodypd = document.getElementById(bodyId),
            headerpd = document.getElementById(headerId)

        // Validate that all variables exist
        if(toggle && nav && bodypd && headerpd){
            toggle.addEventListener('click', ()=>{
                // show navbar
                nav.classList.toggle('show')
                // change icon
                toggle.classList.toggle('bx-x')
                // add padding to body
                bodypd.classList.toggle('body-pd')
                // add padding to header
                headerpd.classList.toggle('body-pd')
            })
        }
    }

    showNavbar('header-toggle','nav-bar','body-pd','header')

    /*===== LINK ACTIVE =====*/
    const linkColor = document.querySelectorAll('.nav_link')

    function colorLink(){
        if(linkColor){
            linkColor.forEach(l=> l.classList.remove('active'))
            this.classList.add('active')
        }
    }
    linkColor.forEach(l=> l.addEventListener('click', colorLink))

});

$('#dashboardPanel').show();
$('#customerPanel').hide();
$('#driverPanel').hide();
$('#carPanel').hide();

$('#btnDashboard').click(function () {
    $('#dashboardPanel').show();
    $('#customerPanel').hide();
    $('#driverPanel').hide();
    $('#carPanel').hide();
});

$('#btnCustomer').click(function () {
    $('#customerPanel').show();
    $('#dashboardPanel').hide();
    $('#driverPanel').hide();
    $('#carPanel').hide();
    loadAllCustomers();
});

$('#btnDriver').click(function () {
    $('#driverPanel').show();
    $('#customerPanel').hide();
    $('#dashboardPanel').hide();
    $('#carPanel').hide();
    loadAllDrivers();
});

$('#btnCar').click(function () {
    $('#carPanel').show();
    $('#driverPanel').hide();
    $('#customerPanel').hide();
    $('#dashboardPanel').hide();
});



$('#btnDriverReg').click(function () {
    addDriver();
});




let mainLink = "http://localhost:8080/Back_End_war/";



// Customer

function loadAllCustomers(){
    $.ajax({
        url : mainLink + "customer",
        success : function(res){

            let customers = $(res.data);
            $('#tblCustomer').empty();

            for(let i = 0; i < customers.length; i++){
                let id = customers[i].customerID;
                let name = customers[i].name;
                let address = customers[i].address;
                let email = customers[i].email;
                let nic = customers[i].nicNo;

                let row =`<tr><td>${id}</td><td>${name}</td><td>${address}</td><td>${email}</td><td>${nic
                }</td></tr>`;
                $('#tblCustomer').append(row);
            }
        }
    });
}





// Driver

function addDriver(){

    let driverId = $('#inputDriverId').val();
    let diverName = $('#inputDriverName').val();
    let driverEmail = $('#inputDriverEmail').val();
    let driverNicNo = $('#inputDriverNicLicNo').val();
    let driverNicNoImg = $('#driverNicImg').val();
    let username = $('#inputDriverUserName').val();
    let password = $('#inputDriverPassword').val();

    let driver = {
        driverID:driverId,
        drivingLicenceNo:driverNicNo,
        driverName:diverName,
        email:driverEmail,
        licenseImage:driverNicNoImg,
        user:{
            username:username,
            password:password,
            Role:"DRIVER"
        }
    }


    $.ajax({
        url : mainLink + 'driver',
        method : "post",
        data : JSON.stringify(driver),
        contentType : 'application/json',
        success:function(){
            console.log("Success")
        },
        error : function(){
            console.log("Error")
        }
    });

}


function loadAllDrivers(){
    $.ajax({
        url : mainLink + "driver",
        success : function(res){

            let drivers = $(res.data);
            $('#tblDriver').empty();

            for(let i = 0; i < drivers.length; i++){
                let driverId = drivers[i].driverID;
                let license = drivers[i].drivingLicenceNo;
                let email = drivers[i].email;

                let row =`<tr><td>${driverId}</td><td>${license}</td><td>${email}</td></tr>`;
                $('#tblDriver').append(row);
            }
        }
    });
}






// Car

let carType;
let fuelType;
let passenger;
let gear;


$("#listType li a").click(function(){
    var selText = $(this).text();
    $('#btnCarType').text(selText);
    carType = selText;
});

$("#listFuelType li a").click(function(){
    var selText = $(this).text();
    $('#btnFuelType').text(selText);
    fuelType = selText;
});

function addCar(){


}











