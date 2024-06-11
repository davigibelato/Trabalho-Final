
window.onload = function () {
    // Máscara para o campo de CPF
    var cpfInput = document.getElementById('cpf');
    cpfInput.addEventListener('input', function () {
        var value = cpfInput.value;
        value = value.replace(/\D/g, ''); // Remove caracteres não numéricos

        if (value.length > 11) {
            value = value.slice(0, 11); // Limita a 11 dígitos
        }

        // Aplica a máscara progressivamente
        if (value.length > 3 && value.length <= 6) {
            value = value.replace(/(\d{3})(\d+)/, '$1.$2');
        } else if (value.length > 6 && value.length <= 9) {
            value = value.replace(/(\d{3})(\d{3})(\d+)/, '$1.$2.$3');
        } else if (value.length > 9) {
            value = value.replace(/(\d{3})(\d{3})(\d{3})(\d{1,2})/, '$1.$2.$3-$4');
        }

        cpfInput.value = value;
    });

    // Máscara para o campo de telefone
    var telefoneInput = document.getElementById('telefone');
    telefoneInput.addEventListener('input', function () {
        var value = telefoneInput.value;
        value = value.replace(/\D/g, ''); // Remove caracteres não numéricos

        if (value.length > 11) {
            value = value.slice(0, 11); // Limita a 11 dígitos
        }

        // Aplica a máscara progressivamente
        if (value.length > 2 && value.length <= 6) {
            value = value.replace(/(\d{2})(\d+)/, '($1) $2');
        } else if (value.length > 6) {
            value = value.replace(/(\d{2})(\d{4,5})(\d+)/, '($1) $2-$3');
        }

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

    // Verificando se o nome contém pelo menos um espaço
    if (!nome.includes(' ')) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'O nome deve conter pelo menos um espaço (nome completo).'
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

    // Verificando se o CPF está completo
    var cpfRegex = /^\d{3}\.\d{3}\.\d{3}-\d{2}$/;
    if (!cpfRegex.test(cpf)) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'CPF inválido! Certifique-se de que ele esteja completo e correto.'
        });
        return false; // Impede o envio do formulário
    }

    // Verificando se o telefone está completo
    var telefoneRegex = /^\(\d{2}\) \d{4,5}-\d{4}$/;
    if (!telefoneRegex.test(telefone)) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Telefone inválido! Certifique-se de que ele esteja completo e correto.'
        });
        return false; // Impede o envio do formulário
    }

    // Permite o envio do formulário
    return true;
}