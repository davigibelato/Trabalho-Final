window.onload = function() {
    var numeroCartaoInputs = document.querySelectorAll('.form-control.numero-cartao');
    var cvvInputs = document.querySelectorAll('.form-control.cvv');
    var dataValidadeInputs = document.querySelectorAll('.form-control.data-validade');
    var nomeTitularInputs = document.querySelectorAll('.form-control.nome-titular');

    // Função para limitar o número de caracteres
    function limitarCaracteres(input, maxLength) {
        if (input.value.length > maxLength) {
            input.value = input.value.slice(0, maxLength);
        }
    }

    // Função para formatar número do cartão
    function formatarNumeroCartao(input) {
        input.value = input.value.replace(/\D/g, ''); // Remove caracteres não numéricos
        input.value = input.value.replace(/(.{4})/g, '$1 ').trim(); // Adiciona espaço a cada 4 dígitos
    }

    // Função para formatar data de validade
    function formatarDataValidade(input) {
        input.value = input.value.replace(/\D/g, ''); // Remove caracteres não numéricos
        input.value = input.value.replace(/^(\d{2})(\d{0,2})/, '$1/$2'); // Formata como MM/AA
    }

    // Função para validar todos os campos preenchidos
    function validarCampos() {
        var camposPreenchidos = true;

        numeroCartaoInputs.forEach(function(input) {
            if (input.value.trim() === '') {
                camposPreenchidos = false;
            }
        });

        cvvInputs.forEach(function(input) {
            if (input.value.trim() === '') {
                camposPreenchidos = false;
            }
        });

        dataValidadeInputs.forEach(function(input) {
            if (input.value.trim() === '') {
                camposPreenchidos = false;
            } else {
                var data = input.value.split('/');
                var ano = parseInt(data[1]);
                if (ano < 24 || isNaN(ano)) { // Verifica se o ano é menor que 2024 ou não é um número
                    camposPreenchidos = false;
                }
            }
        });

        nomeTitularInputs.forEach(function(input) {
            if (!/^[a-zA-Z0-9\s]*$/.test(input.value.trim())) { // Verifica se há apenas letras, números e espaços
                camposPreenchidos = false;
            }
        });

        return camposPreenchidos;
    }

    // Adiciona eventos de entrada para limitar o número de caracteres e formatar os valores
    numeroCartaoInputs.forEach(function(input) {
        input.addEventListener('input', function() {
            limitarCaracteres(input, 19); // Limita a 19 caracteres (incluindo espaços)
            formatarNumeroCartao(input); // Formata o número do cartão
        });
    });

    cvvInputs.forEach(function(input) {
        input.addEventListener('input', function() {
            limitarCaracteres(input, 3); // Limita a 3 caracteres
        });
    });

    dataValidadeInputs.forEach(function(input) {
        input.addEventListener('input', function() {
            limitarCaracteres(input, 5); // Limita a 5 caracteres (MM/AA)
            formatarDataValidade(input); // Formata a data de validade
        });
    });

    // Adiciona evento de envio do formulário
    document.querySelector('form').addEventListener('submit', function(event) {
        if (!validarCampos()) {
            event.preventDefault(); // Impede o envio do formulário
            swal("Erro!", "Por favor, preencha todos os campos corretamente.", "error");
        }
    });
};
