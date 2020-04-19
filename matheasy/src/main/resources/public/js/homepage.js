$(document).ready(function() {
	$('.navFragments').click(function(e) {
		let url = './homepage/';
		const nameFrag = e.target.name;
		
		$('#fragmento').load(url + nameFrag);
	});
});