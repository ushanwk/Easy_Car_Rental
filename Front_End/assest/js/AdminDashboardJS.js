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
$('#allBookingPanel').hide();

$('#btnDashboard').click(function () {
    $('#dashboardPanel').show();
    $('#customerPanel').hide();
    $('#driverPanel').hide();
    $('#carPanel').hide();
    $('#allCarPanel').hide();
    $('#allBookingPanel').hide();
});

$('#btnCustomer').click(function () {
    $('#customerPanel').show();
    $('#dashboardPanel').hide();
    $('#driverPanel').hide();
    $('#carPanel').hide();
    $('#allCarPanel').hide();
    $('#allBookingPanel').hide();
    loadAllCustomers();
});

$('#btnDriver').click(function () {
    $('#driverPanel').show();
    $('#customerPanel').hide();
    $('#dashboardPanel').hide();
    $('#carPanel').hide();
    $('#allCarPanel').hide();
    $('#allBookingPanel').hide();
    loadAllDrivers();
});

$('#btnCar').click(function () {
    $('#carPanel').show();
    $('#driverPanel').hide();
    $('#customerPanel').hide();
    $('#dashboardPanel').hide();
    $('#allCarPanel').hide();
    $('#allBookingPanel').hide();
});

$('#btnCarAll').click(function () {
    $('#carPanel').hide();
    $('#driverPanel').hide();
    $('#customerPanel').hide();
    $('#dashboardPanel').hide();
    $('#allCarPanel').show();
    $('#allBookingPanel').hide();
    loadAllCars();
});

$('#btnBooking').click(function () {
    $('#carPanel').hide();
    $('#driverPanel').hide();
    $('#customerPanel').hide();
    $('#dashboardPanel').hide();
    $('#allCarPanel').hide();
    $('#allBookingPanel').show();
    loadAllRents();
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
                let nicImg = "../assest/projectimages/customerimages/frontimage/front_" + id + ".jpeg";

                let row =`<tr><td>${id}</td><td>${name}</td><td>${address}</td><td>${email}</td><td>${nic}</td><td><img style="width: 30%" src="${nicImg}"></td></tr>`;
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
            role:"DRIVER"
        }
    }


    $.ajax({
        url : mainLink + 'driver',
        method : "post",
        data : JSON.stringify(driver),
        contentType : 'application/json',
        success:function(){
            console.log("Success");
            addDriverimage();
            loadAllDrivers();
        },
        error : function(){
            console.log("Error");
        }
    });

}


function addDriverimage(){

    let driverId = $('#inputDriverId').val();

    let formData = new FormData($('#driverForm')[0]);

    $.ajax({
        url : mainLink + 'driver?driverId=' + driverId,
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
                let name = drivers[i].driverName;

                let row =`<tr><td>${driverId}</td><td>${name}</td><td>${license}</td><td>${email}</td><td><button type="button" class="btn btn-danger driverDeleteBtn">Delete</button></td></tr>`;
                $('#tblDriver').append(row);

               deleteRow(driverId);

            }
        }
    });
}

function deleteRow(id) {
    $('.driverDeleteBtn').off('click');
    $('.driverDeleteBtn').click(function () {
        $(this).closest('tr').remove();

        $.ajax({
            url : mainLink + 'driver?driverId=' + id,
            method : "delete",
            sync:true,
            success:function(){
                console.log("Deleted")
            },
            error : function(){
                console.log("Error")
            }
        });

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
        method : 'post',
        data : JSON.stringify(car),
        contentType : 'application/json',
        success:function(){
            console.log("Success");
            saveCarImages();
        },
        error : function(){
            console.log("Error");
        }
    });

}




function saveCarImages(){

    let carID = $('#inputCarId').val();

    let formData = new FormData($('#carForm')[0]);

    $.ajax({
        url : mainLink + 'car?carID=' + carID,
        method : "post",
        header:"Access-Control-Allow-Origin",
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






function loadAllRents(){

    let customers;

    $.ajax({
        url : mainLink + "customer",
        success : function (res){
            customers = $(res.data);
        }
    });


    $.ajax({
        url : mainLink + "rent",
        success : function(res){
            $('#tblAllBooking').empty();
            let rents = $(res.data);

            for(let i = 0; i < rents.length; i++){

                let rentId = rents[i].rentID;
                let cusId = rents[i].customerID;
                let pickupDate = rents[i].pickupDate;
                let pickupTime = rents[i].pickupTime;
                let status = rents[i].status;
                let cusName = "name"

                for(let k = 0; k < customers.length; k++){
                    if(customers[k].customerID == cusId){
                        cusName = customers[k].name;
                    }
                }

                let row =`<tr><td>${rentId}</td><td>${cusName}</td><td>${pickupDate}</td><td>${pickupTime}</td><td>${status}</td></tr>`;
                $('#tblAllBooking').append(row);

            }

            $('#tblAllBooking>tr').click(function () {

                $('#tblOneBook').empty();

                let clickedRentId = $(this).children().eq(0).text();

                $('#rentIdtoHide').text(clickedRentId);

                for(let k = 0; k < rents.length; k++){

                    if(rents[k].rentID == clickedRentId){

                        for(let u = 0; u < rents[k].rentDetails.length; u++){

                            let car = rents[k].rentDetails[u].carID;
                            let wavier = "Done";
                            let driver = rents[k].rentDetails[u].driverID

                            let row =`<tr><td>${car}</td><td>${wavier}</td><td>${driver}</td></tr>`;
                            $('#tblOneBook').append(row);

                        }

                        break;
                    }

                }

            });

        }
    });

}


$('#btnAcceptRent').click(function () {

    $.ajax({
        url : mainLink + '/rentdetail?rentId=' + $('#rentIdtoHide').text(),
        method : "post",
        sync:true,
        success:function(){
            console.log("Status update succesfully");
            loadAllRents()
        },
        error : function(){
            console.log("Error")
        }
    });

});










