let pushHide = document.querySelectorAll('div.all-comments');

pushHide.forEach(function(elem) {
    elem.addEventListener('click', function() {
        let button = elem.querySelector('.middle');
        let comment = elem.querySelector('.selectAllComments');
        if (button.classList.contains('middle-hide')) {
            button.classList.toggle('middle-unhide');
            button.classList.toggle('middle-hide');
            comment.style.display = 'inline-table';
            button.querySelector('#try1').style.display='none';
            button.querySelector('#try2').style.display='inline';
        } else {
            button.classList.toggle('middle-hide');
            button.classList.toggle('middle-unhide');
            comment.style.display = 'none';
            button.querySelector('#try1').style.display='inline';
            button.querySelector('#try2').style.display='none';
        }
})
});

let confPsw = document.querySelector('button.submit-psw');

confPsw.addEventListener('click', function(e) {
    let psw1 = document.getElementById('password');
    let psw2 = document.getElementById('password2');
    let alert = document.querySelector('.alert');
        if(psw1.value != psw2.value) {
            alert.style.display = 'block';
            e.preventDefault();
        } else {
            alert.style.display = 'none';
        }
});