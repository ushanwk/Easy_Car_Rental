let mainLink = "http://localhost:8080/Back_End_war/";



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

            let car = `

            

            `


            $('#cars').append(car);

        }
    }

});




