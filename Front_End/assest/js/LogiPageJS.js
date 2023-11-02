let mainLink = "http://localhost:8080/Back_End_war/";


generateLoginID();

$('#btnSignIn').click(function () {

    $.ajax({
        url : mainLink + "user",

        success : function(res){

            let users = $(res.data);

            let username = $('#inputUsername').val();
            let password = $('#inputPassword').val();

            let rightUsername = -1;

            console.log(users)

            for(let i = 0; i < users.length; i++){
                if(users[i].username == username){
                    rightUsername = i;
                    break;
                }
            }

            if (rightUsername == -1){
                alert("Invalid Username or Password !");
            }else{

                if(users[rightUsername].password == password){



                    let currentDate = new Date().toJSON().slice(0, 10);

                    const d = new Date();
                    let hours = new Date().getTime();

                    let loginId = $('#txtLogID').text();
                    let us = $('#inputUsername').val();
                    let password = $('#inputPassword').val();
                    let role = users[rightUsername].role

                    let user = {
                        username:us,
                        password:password,
                        role:role
                    }

                    let loginDetail = {
                        loginID: loginId,
                        userName: user,
                        date: currentDate,
                        time: hours
                    }

                    console.log(loginDetail)

                    $.ajax({
                        url : mainLink + 'logindetail',
                        method : "post",
                        data : JSON.stringify(loginDetail),
                        contentType : 'application/json',
                        success:function(){
                            console.log("Success")
                        },
                        error : function(){
                            console.log("Error")
                        }
                    });


                    if(users[rightUsername].role == "CUSTOMER"){
                        window.open("../pages/LogedBrowsePage.html","_self");
                    }else if(users[rightUsername].role == "ADMIN"){
                        window.open("../pages/AdminDashboardPage.html","_self");
                    } else {
                        alert("Driver")
                    }

                }else {
                    alert("Invalid Username or Password !");
                }
            }


        }

    });

});



function generateLoginID() {
    $.ajax({
        url: "http://localhost:8080/Back_End_war/logindetail/IdGenerate",
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (resp) {
            let id = resp.value;

            if(id === null){
                id = "Log00-001"
                $("#txtLogID").text(id);
            }else{
                let tempId = parseInt(id.split("-")[1]);
                tempId = tempId + 1;
                if (tempId <= 9) {
                    $("#txtLogID").text("Log00-00" + tempId);
                } else if (tempId <= 99) {
                    $("#txtLogID").text("Log00-0" + tempId);
                } else {
                    $("#txtLogID").text("Log00-" + tempId);
                }
            }


        },
        error: function (ob, statusText, error) {

        }
    });
}