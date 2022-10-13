const registerButton = document.querySelector(".account-button");

registerButton.onclick = () => {
    const accountInputs = document.querySelectorAll(".account-input");


    let user = {
        lastName: accountInputs[0].value,
        firstName: accountInputs[1].value,
        email:accountInputs[2].value,
        password:accountInputs[3].value,
    }

    $.ajax ({
        async: false,
        type:"post",
        url:"/api/account/register",
        contentType: "application/json",
        data: JSON.stringify(user),
        dataType: "json",
        success: (response) => {
           
        },
        error: (error) => {
          
            console.log(error.responseJSON.data);
            loadErrorMessage(error.responseJSON.data);
        }
    })
    $.ajax();
}

function loadErrorMessage(errors) {
    const errorList = document.querySelector(".errors")
    const errorMsgs = document.querySelector(".error-msgs")
    const errorArray=Object.values(errors)


    errorMsgs.innerHTML ="";

    errorArray.forEach(error => {
        errorMsgs.innerHTML += `
        <li>${error}</li>
        `;
    });

    errorList.classList.remove("errors-invisible");

}
