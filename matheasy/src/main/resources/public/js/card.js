// Arrays
let arrayOfCards = [];
let arrayOfFrag = [];
let drag;

// Objetos

// Obejto Fragment
function Fragment() {
    this.id = arrayOfFrag.length + 1;
}
// função que retorna o fragmento de código
Fragment.prototype.fragment = function(id) {
    const fragText =
        '<div class="card" id="' + id + '">' +
        '<div class="card-body">' +
        '<div class="card-nav">' +
        '<h2 class="title">Titulo</h2>' +
        '</div>' +
        '<div class="card-content">' +
        '<p class="area">Digite aqui...</p>' +
        '</div>' +
        '<div class="card-footer">' +
        '<footer>' +
        '<button id="bt-deletar">' +
        '<i class="large material-icons">delete</i>' +
        '</button>' +
        '</footer>' +
        '</div>' +
        '</div>' +
        '</div>';
    const fragElm = textToElement();

    function textToElement() {
        return $.parseHTML(fragText);
    }


    arrayOfFrag.push(fragElm);
    return fragElm;
}

// Objeto Card
function Card(title, color, img, text, frag) {
    this.id = arrayOfCards.length + 1;
    this.title = title;
    this.frag = frag;
    this.color = color;
    this.img = img;
    this.text = text;
    this.favorite = false;
}

// Função que inicia a tela do grid
function start(/* array */) {
    drag = dragula([document.querySelector(".container-cards")]);
}

// Adicionar Cards
function createCardElement() {
    const frag = new Fragment();

    const block = createCardObject(
        "",
        "red",
        new Image(),
        "",
        frag.fragment(frag.id)
    );

    // adiciona ao conteúdo da página
    $('.container-cards').append(block.frag);
    drag.containers.push(block.frag);

}

// cria objeto Card
function createCardObject(title, color, img, text, frag) {
    const card = new Card(title, color, img, text, frag);
    arrayOfCards.push(card);
    return card;
}

// função de filtro
function filterCards() {
    const conteudo = getContent();

    // mantem cor se conteudo for vazio
    if (conteudo.length === 0) {
        $(".container-cards .card").map(function() {
            $(this).css("display", "flex");
        });
        return;
    }
    // captura todos os elementos do filtro
    let arrayOfValues = $(".container-cards p").map(function() {
        if ($(this).text().toLowerCase().includes(conteudo)) {
            return $(this).parents(".card")[0];
        }
        $(this).parents(".card").css("display", "none");
    });

    // efeito quando encontrado
    arrayOfValues.map(function() {
        $(this).css("display", "flex");
    });

    // retorna valor do campo de pesquisa
    function getContent() {
        return $('#campo_pesquisar').val().toLowerCase();
    }
}

// Deleta Cards
function deleteCard(id) {
    $('#' + id).hide(5000).remove();

    arrayOfCards = $.grep(arrayOfCards, function(elm) {
        return elm.id !== id;
    });
}

// Editar
function prepareForEdit(idCard) {
    const elm = findCardById(idCard);

    if(elm){    	
    	$('#form-edicao').attr('action', '/card/'+ idCard);
    	$('#title').val(elm.title);
    	$('#area').val(elm.text);
    }else{
    	$('#form-edicao').attr('action', '/card/'+ idCard);    	
    }
}

function findCardById(idCard) {
    let cardFound = arrayOfCards.find(elm => elm.id === idCard);
    return cardFound;
}

// Salva
function save(id) {
    const oldCard = findCardById(id);
    const newCard = oldCard;

    newCard.title = $('#title').val();
    newCard.text = $('#area').val();

    $('#' + id + ' h2').html(newCard.title);
    $('#' + id + ' p').html(newCard.text);

    updateArrayOfCards(oldCard, newCard);
    // Fecha card de edição
    $('.container-opened').css("display", "none");
}

function updateArrayOfCards(oldCard, newCard) {
    arrayOfCards = $.grep(arrayOfCards, function(elm) {
        return elm !== oldCard;
    });
    arrayOfCards.push(newCard);
}

// ------------------- EVENTOS -----------------------

// Deleta card clicado
$('.container-cards').on("click", ".bt-deletar", function(event) {
	const id = $(this).parents('.card').attr('id');
// const idNum = id.replace(/\D+/g, "");
	
// console.log(idNum);
	
    deleteCard(id);
});

// Salva card edição
$('.container-opened').on("click", "#bt-salvar", function() {
    const id = $(this).parents('.container-opened').attr('id');

    save(id);
});

// Abre Card de edição
$('.container-cards').on("click", ".card-content", function() {
    const id = $(this).parents('.card').attr('id');
    $('.container-opened').css("display", "flex").attr('id', id);
    
    prepareForEdit(id);
});

// Inicia grid
$(document).ready(function() {
    start();
});