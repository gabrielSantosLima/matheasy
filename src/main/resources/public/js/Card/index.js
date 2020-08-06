// Arrays
let arrayOfCards = [];
let drag;
let ids;
let titles;
let areas;

// Objetos

// Obejto Fragment
function Fragment() {
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
    return fragElm;
}

// Objeto Card
function Card(id, title, text, frag) {
    this.id = id;
    this.title = title;
    this.text = text;
    this.frag = frag;
    this.favorite = false;
}

// Função que inicia a tela do grid
function start() {
	drag = dragula([document.querySelector(".container-cards")]);
}

function getInitialCards(){
	ids = getChildrenByParent('.container-cards','.card');
	titles = getChildrenByParent('.container-cards','h2');
	areas = getChildrenByParent('.container-cards','p');
    	
    const length = ids.length;
 
	function getChildrenByParent(parent,children){
		return $(parent).find(children);
	}
    	
	for(let cont = 0; cont < length; cont++){
		let frag = new Fragment();
		let id = ids[cont].id;
		let title = titles[cont].textContent;
		let area = areas[cont].textContent;
		
		createCardObject(id, title, area, frag.fragment(id));
	}
}

getInitialCards();

// Adicionar Cards
function createCardElement() {
    const frag = new Fragment();

    const block = createCardObject(
    	arrayOfCards.length + 1,
    	"",
        "",
        frag.fragment(arrayOfCards.length + 1)
    );

    // adiciona ao conteúdo da página
    $('.container-cards').append(block.frag);
    drag.containers.push(block.frag);

}

// cria objeto Card
function createCardObject(id, title, text, frag) {
    const card = new Card(id, title, text, frag);
    
    arrayOfCards.push(card);
    return card;
}

// função de filtro
function filterCards() {
    const conteudo = getCampoPesquisa();

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
    function getCampoPesquisa() {
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