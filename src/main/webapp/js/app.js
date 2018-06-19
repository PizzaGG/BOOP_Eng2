/*
 * Replace all SVG images with inline SVG
 */
jQuery('img.svg').each(function(){
    var $img = jQuery(this);
    var imgID = $img.attr('id');
    var imgClass = $img.attr('class');
    var imgURL = $img.attr('src');

    jQuery.get(imgURL, function(data) {
        // Get the SVG tag, ignore the rest
        var $svg = jQuery(data).find('svg');

        // Add replaced image's ID to the new SVG
        if(typeof imgID !== 'undefined') {
            $svg = $svg.attr('id', imgID);
        }
        // Add replaced image's classes to the new SVG
        if(typeof imgClass !== 'undefined') {
            $svg = $svg.attr('class', imgClass+' replaced-svg');
        }

        // Remove any invalid XML tags as per http://validator.w3.org
        $svg = $svg.removeAttr('xmlns:a');

        // Check if the viewport is set, if the viewport is not set the SVG wont't scale.
        if(!$svg.attr('viewBox') && $svg.attr('height') && $svg.attr('width')) {
            $svg.attr('viewBox', '0 0 ' + $svg.attr('height') + ' ' + $svg.attr('width'))
        }

        // Replace image with new SVG
        $img.replaceWith($svg);

    }, 'xml');

});

const editarBtn = document.getElementById('editarBtn');
const cancelarBtn = document.getElementById('cancelarBtn');
const excluirBtn = document.getElementById('excluirBtn');
const inputFile = document.querySelector('.inputFile');
const inputEdit = document.querySelectorAll('.inputEdit');

editarBtn.addEventListener('click', () => {
    editarBtn.classList.add('d-none');
    editarBtn.classList.remove('d-block');
    cancelarBtn.classList.remove('d-none');
    cancelarBtn.classList.add('d-block');
    cancelarBtn.previousElementSibling.classList.remove('d-none');
    cancelarBtn.previousElementSibling.classList.add('d-block');
    inputEdit.forEach((input) => {
        input.disabled = false;
    });
    
    if(excluirBtn) {
    	excluirBtn.classList.remove('d-none');
        excluirBtn.classList.add('d-block');
    }
    
    if(inputFile) {
    	inputFile.classList.add('d-block');
        inputFile.classList.remove('d-none');
    }
    
});

cancelarBtn.addEventListener('click', () => {
    editarBtn.classList.remove('d-none');
    editarBtn.classList.add('d-block');
    cancelarBtn.classList.remove('d-block');
    cancelarBtn.classList.add('d-none');
    cancelarBtn.previousElementSibling.classList.remove('d-block');
    cancelarBtn.previousElementSibling.classList.add('d-none');
    inputEdit.forEach((input) => {
        input.disabled = true;
    });
    
    if(excluirBtn) {
    	excluirBtn.classList.remove('d-block');
        excluirBtn.classList.add('d-none');
    }
    
    if(inputFile) {
    	inputFile.classList.add('d-none');
        inputFile.classList.remove('d-block');
    }
});