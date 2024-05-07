const form = document.getElementById("form-cadastrar");

form.addEventListener("submit", function (event){

    const email = form.getElementById("email").value.trim();
    const senha = form.getElementById("senha").value.trim();
    const telefone = fomr.getElementById("telefone").value.trim();
    const cpf = form.getElementById("cpf").value.trim();

    if(email === "" || senha === "" || telefone === 0 || cpf === 0){
        Swal.fire({
            icon: "error",
            title: "Calma ái",
            text: "Preencha todos os campos!",
          });
    }else{
        form.submit(); 
    }

});