let mainLink = "http://localhost:8080/Back_End_war/";

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
                alert("Invalid Username or Password !")
            }else{

                if(users[rightUsername].password == password){

                    if(users[rightUsername].role == "CUSTOMER"){
                        window.open("../pages/LogedBrowsePage.html","_self");
                    }else {
                        alert("Driver")
                    }

                }else {
                    alert("Invalid Username or Password !")
                }

            }


        }

    });

});