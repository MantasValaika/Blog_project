let pushHide = document.querySelectorAll('div.middle-hide');
let unhideText = document.querySelector('div.middle-hide p');
let comment = document.querySelector('div.comment');

pushHide.forEach(function(elem) {
    elem.addEventListener('click', function() {
        if (elem.classList.contains('middle-hide')) {
            elem.classList.add('middle-unhide');
            elem.classList.remove('middle-hide');
            comment.style.visibility  = 'visible';
            comment.style.height  = '100%';
            unhideText.textContent='Hide comment';
        } else {
            elem.classList.add('middle-hide');
            elem.classList.remove('middle-unhide');
            unhideText.textContent='View comment'
            comment.style.visibility = 'hidden';
            comment.style.height  = '0px';
        }
})
});