$(document).ready(() => {

    $('.navFragments').click(function(e) {
        let url = './homepage/';
        const nameFrag = e.target.name;

        $('#fragmento').load(url + nameFrag);
    });

});