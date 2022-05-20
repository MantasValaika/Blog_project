let pushHide = document.querySelectorAll('div.all-comments');

pushHide.forEach(function(elem) {
    elem.addEventListener('click', function() {
        let button = elem.querySelector('.middle');
        let comment = elem.querySelector('.comment');
        if (button.classList.contains('middle-hide')) {
            button.classList.toggle('middle-unhide');
            button.classList.toggle('middle-hide');
            comment.style.display = 'none';
            button.querySelector('#try1').style.display='none';
            button.querySelector('#try2').style.display='inline';
        } else {
            button.classList.toggle('middle-hide');
            button.classList.toggle('middle-unhide');
            comment.style.display = 'block';
            button.querySelector('#try1').style.display='inline';
            button.querySelector('#try2').style.display='none';
        }
})
});