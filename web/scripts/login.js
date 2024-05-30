function verificarCampos() {
    var email = document.getElementById('email').value;
    var senha = document.getElementById('senha').value;

    // Verificando se os campos estão vazios
    if (email.trim() === '' || senha.trim() === '') {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, preencha todos os campos!'
        });
        return false; // Impede o envio do formulário
    }

    return true; // Permite o envio do formulário
}