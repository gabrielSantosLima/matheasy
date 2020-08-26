/* MODAL */

const openPopupButtons = document.querySelectorAll('[data-modal-target]')
const closePopupButtons = document.querySelectorAll('[data-close-button]')
const overlay = document.getElementById('overlay')

openPopupButtons.forEach(button => {
  button.addEventListener('click', () => {
    const popup = document.querySelector(button.dataset.modalTarget)
    openPopup(popup)
  })
})

overlay.addEventListener('click', () => {
  const popups = document.querySelectorAll('.popup.active')
  popups.forEach(popup => {
    closePopup(popup)
  })
})

closePopupButtons.forEach(button => {
  button.addEventListener('click', () => {
    const popup = button.closest('.popup')
    closePopup(popup)
  })
})

function openPopup(popup) {
  if (popup == null) return
  popup.classList.add('active')
  overlay.classList.add('active')
}

function closePopup(popup) {
  if (popup == null) return
  popup.classList.remove('active')
  overlay.classList.remove('active')
  changeImage()
}

// Desenho

const tagSVG = document.querySelector('svg');
const pathDoSVG = document.querySelector('svg path');
const tamanhoTotalDoPath = pathDoSVG.getTotalLength();
tagSVG.style.setProperty('--tamanhoTotalDoPath', tamanhoTotalDoPath);

console.log(tamanhoTotalDoPath); // 3749.863525390625

tamanhoTotalDoPath.style.WebkitTransition = 'none';
tamanhoTotalDoPath.style.strokeDasharray = len + ' ' + len;
tamanhoTotalDoPath.style.strokeDashoffset = len;
tamanhoTotalDoPath.getBoundingClientRect();
tamanhoTotalDoPath.style.transition = p.style.WebkitTransition = 'stroke-dashoffset 5s ease-in-out';
tamanhoTotalDoPath.style.strokeDashoffset = '0';

// Botões

function edit() {
    document.querySelector('#user').readOnly = false;
    document.querySelector('#email').readOnly = false;
    document.querySelector('#date').readOnly = false;

    document.querySelector('.edit').style.display = 'none';
    document.querySelector('.save').style.display= 'inline-block';
    document.querySelector('.cancel').style.display= 'inline-block';
}

function discart() {
    document.querySelector('#user').readOnly = true;
    document.querySelector('#email').readOnly = true;
    document.querySelector('#date').readOnly = true;

    document.querySelector('.edit').style.display = 'inline-block';
    document.querySelector('.save').style.display= 'none';
    document.querySelector('.cancel').style.display= 'none';
}

function changeImage(){
    const file = document.querySelector('#controlfile').files[0]
    const reader = new FileReader();

    reader.onloadend = () => {
    	document.querySelector('#img-perfil').src = reader.result;
    }

    if(file){
        reader.readAsDataURL(file)
    }

    console.log(file)
}

