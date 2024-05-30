window.onload = function () {
    // Máscara para o campo de CPF
    var cpfInput = document.getElementById('cpf');
    cpfInput.addEventListener('input', function () {
        var value = cpfInput.value;
        value = value.replace(/\D/g, ''); // Remove caracteres não numéricos
        value = value.replace(/^(\d{3})(\d{3})(\d{3})(\d{2})$/, '$1.$2.$3-$4'); // Aplica a máscara
        cpfInput.value = value;
    });

    // Máscara para o campo de telefone
    var telefoneInput = document.getElementById('telefone');
    telefoneInput.addEventListener('input', function () {
        var value = telefoneInput.value;
        value = value.replace(/\D/g, ''); // Remove caracteres não numéricos
        value = value.replace(/^(\d{2})(\d{4,5})(\d{4})$/, '($1) $2-$3'); // Aplica a máscara
        telefoneInput.value = value;
    });
};

function verificarCampos() {

    var nome = document.getElementById('nome').value;
    var email = document.getElementById('email').value;
    var senha = document.getElementById('senha').value;
    var confirmarSenha = document.getElementById('confirmarSenha').value;
    var cpf = document.getElementById('cpf').value;
    var telefone = document.getElementById('telefone').value;

    // Verificando se algum campo está vazio
    if (nome.trim() === '' || email.trim() === '' || senha.trim() === '' || confirmarSenha.trim() === '' || cpf.trim() === '' || telefone.trim() === '') {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Por favor, preencha todos os campos!'
            });
                return false; // Impede o envio do formulário
    }

    // Verificando se as senhas coincidem
    if (senha !== confirmarSenha) {

        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'As senhas não coincidem!'
        });

        return false; // Impede o envio do formulário
    }

    return true; // Permite o envio do formulário
}