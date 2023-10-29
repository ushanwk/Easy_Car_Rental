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
$('#allCarPanel').hide();

$('#btnDashboard').click(function () {
    $('#dashboardPanel').show();
    $('#customerPanel').hide();
    $('#driverPanel').hide();
    $('#carPanel').hide();
    $('#allCarPanel').hide();
});

$('#btnCustomer').click(function () {
    $('#customerPanel').show();
    $('#dashboardPanel').hide();
    $('#driverPanel').hide();
    $('#carPanel').hide();
    $('#allCarPanel').hide();
    loadAllCustomers();
});

$('#btnDriver').click(function () {
    $('#driverPanel').show();
    $('#customerPanel').hide();
    $('#dashboardPanel').hide();
    $('#carPanel').hide();
    $('#allCarPanel').hide();
    loadAllDrivers();
});

$('#btnCar').click(function () {
    $('#carPanel').show();
    $('#driverPanel').hide();
    $('#customerPanel').hide();
    $('#dashboardPanel').hide();
    $('#allCarPanel').hide();
});

$('#btnCarAll').click(function () {
    $('#carPanel').hide();
    $('#driverPanel').hide();
    $('#customerPanel').hide();
    $('#dashboardPanel').hide();
    $('#allCarPanel').show();
    loadAllCars();
});



$('#btnDriverReg').click(function () {
    addDriver();
});

$('#btnCarAdd').click(function () {
    addCar();
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
            console.log("Success");
            loadAllDrivers();
        },
        error : function(){
            console.log("Error");
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
let carFuelType;
let carPassenger;
let carGear;


$("#listType li a").click(function(){
    var selText = $(this).text();
    $('#btnCarType').text(selText);
    carType = selText;
});

$("#listFuelType li a").click(function(){
    var selText = $(this).text();
    $('#btnFuelType').text(selText);
    carFuelType = selText;
});

$("#listPassenger li a").click(function(){
    var selText = $(this).text();
    $('#btnPassenger').text(selText);
    carPassenger = selText;
});

$("#listGear li a").click(function(){
    var selText = $(this).text();
    $('#btnGear').text(selText);
    carGear = selText;
});

function addCar(){

    let type = carType;
    let fuelType = carFuelType;
    let passenger = carPassenger;
    let transmissionType = carGear;
    let carID = $('#inputCarId').val();
    let backImage = $('#inputCarBackView').val();
    let availability = "Available";
    let brand = $('#inputCarBrand').val();
    let color = $('#inputCarColor').val();
    let currentMilage = $('#inputCarMilage').val();
    let extraMilagePrice = $('#inputCarRentPriceExtraKm').val();
    let freeMilageDailyPrice = $('#inputCarRentDaily').val();
    let freeMilageDaily = $('#inputCarRentMilage').val();
    let freeMilageMonthlyPrice = $('#inputCarRentMonthly').val();
    let freeMilageMonthly = freeMilageDaily * 30;
    let frontImage = $('#inputCarFrontView').val();
    let interiorImage = $('#inputCarInteriorView').val();
    let regNo = $('#inputRegNo').val();
    let sideImage = $('#inputCarSidetView').val();
    let wavierPayment = $('#inputCarWavier').val();

    let car = {
        type:type,
        fuelType:fuelType,
        passenger:passenger,
        transmissionType:transmissionType,
        carID:carID,
        backImage:backImage,
        availability:availability,
        brand:brand,
        color:color,
        currentMileage:currentMilage,
        extraMileagePrice:extraMilagePrice,
        freeMileageDailyPrice:freeMilageDailyPrice,
        freeMileageDaily:freeMilageDaily,
        freeMileageMonthlyPrice:freeMilageMonthlyPrice,
        freeMileageMonthly:freeMilageMonthly,
        frontImage:frontImage,
        interiorImage:interiorImage,
        regNo:regNo,
        sideImage:sideImage,
        wavierPayment:wavierPayment
    }

    $.ajax({
        url : mainLink + 'car',
        method : "post",
        data : JSON.stringify(car),
        contentType : 'application/json',
        success:function(){
            console.log("Success")
            saveCarImages();
        },
        error : function(){
            console.log("Error")
        }
    });




}




function saveCarImages(){

    let carID = $('#inputCarId').val();

    let formData = new FormData($('#carForm')[0]);

    $.ajax({
        url : mainLink + 'car?carID=' + carID,
        method : "post",
        async : false,
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


function loadAllCars(){
    $.ajax({
        url : mainLink + "car",
        success : function(res){

            let cars = $(res.data);
            $('#tblAllCar').empty();

            console.log(cars)

            for(let i = 0; i < cars.length; i++){
                let carId = cars[i].carID;
                let brand = cars[i].brand;
                let color = cars[i].color;
                let reg = cars[i].regNo;
                let avl = cars[i].availability;
                let fuel = cars[i].fuelType;
                let wavier = cars[i].wavierPayment;
                let passenger = cars[i].passenger;
                let mil = cars[i].currentMileage;


                let row =`<tr><td>${carId}</td><td>${brand}</td><td>${color}</td><td>${reg}</td><td>${avl}</td><td>${fuel}</td><td>${wavier}</td><td>${passenger}</td><td>${mil}</td></tr>`;
                $('#tblAllCar').append(row);
            }
        }
    });
}











