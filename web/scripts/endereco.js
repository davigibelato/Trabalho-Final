window.onload = function () {
    // Aplicar a formatação de CEP brasileira
    var cepInput = document.getElementById('cep');
    cepInput.addEventListener('input', function () {
        var value = cepInput.value;
        value = value.replace(/\D/g, ''); // Remove caracteres não numéricos
        value = value.slice(0, 8); // Limita a 8 dígitos

        // Verifica se o valor tem mais de 5 caracteres para aplicar a máscara corretamente
        if (value.length > 5) {
            value = value.replace(/^(\d{5})(\d{3})$/, '$1-$2'); // Aplica a máscara
        }

        cepInput.value = value;
    });
};

function validarFormulario() {
    var estado = document.getElementById('estado').value;
    var cidade = document.getElementById('cidade').value;
    var cep = document.getElementById('cep').value;
    var nomeRua = document.getElementById('nomeRua').value;
    var numeroCasa = document.getElementById('numeroCasa').value;

    // Verificar se algum campo está vazio
    if (estado.trim() === '' || cidade.trim() === '' || cep.trim() === '' || nomeRua.trim() === '' || numeroCasa.trim() === '') {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, preencha todos os campos.'
        });
        return false;
    }

    // Verificar se o CEP tem exatamente 8 dígitos
    if (cep.replace(/\D/g, '').length !== 8) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'O CEP deve conter exatamente 8 dígitos.'
        });
        return false;
    }

    return true;
}
