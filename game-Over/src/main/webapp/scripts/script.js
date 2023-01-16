/* Sticky NavBar */
window.addEventListener('scroll', function () {
    var header = document.querySelector('header');
    header.classList.toggle('sticky', window.scrollY > 0);
});

/* Responsive NavBar */
function toggleMenu() {
    const toggleMenu = document.querySelector('.toggleMenu');
    const nav = document.querySelector('.nav')
    toggleMenu.classList.toggle('active')
    nav.classList.toggle('active')
}

/* Scrolling Animation Effects*/
window.addEventListener('scroll', function () {
    var anime = document.querySelectorAll('.animeX');

    for (var s = 0; s < anime.length; s++) {
        var windowheight = window.innerHeight;
        var animetop = anime[s].getBoundingClientRect().top;
        var animepoint = 150;

        if (animetop < windowheight - animepoint) {
            anime[s].classList.add('active');
        } else {
            anime[s].classList.remove('active');
        }
    }
})
/* Filterable Cards */
let list = document.querySelectorAll('.list');
let card = document.querySelectorAll('.card');

for (let i = 0; i < list.length; i++) {

    list[i].addEventListener('click', function () {
        for (let j = 0; j < list.length; j++) {
            list[j].classList.remove('active');
        }
        this.classList.add('active');

        let dataFilter = this.getAttribute('data-filter');

        for (let k = 0; k < card.length; k++) {

            card[k].classList.remove('active');
            card[k].classList.add('hide');

            if (card[k].getAttribute('data-item') == dataFilter || dataFilter == 'all') {

                card[k].classList.remove('hide');
                card[k].classList.add('active');
            }
        }
    })
}

/* Registration Page Next/Prev */
		const slidePage = document.querySelector(".slide-page");
        const nextBtnFirst = document.querySelector(".firstNext");
        const prevBtnSec = document.querySelector(".prev-1");
        const nextBtnSec = document.querySelector(".next-1");
        const prevBtnThird = document.querySelector(".prev-2");
        const nextBtnThird = document.querySelector(".next-2");
        const prevBtnFourth = document.querySelector(".prev-3");
        const submitBtn = document.querySelector(".submit");
        const progressText = document.querySelectorAll(".step p");
        const progressCheck = document.querySelectorAll(".step .check");
        const bullet = document.querySelectorAll(".step .bullet");
        let current = 1;
        nextBtnFirst.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "-25%";
            bullet[current - 1].classList.add("active");
            progressCheck[current - 1].classList.add("active");
            progressText[current - 1].classList.add("active");
            current += 1;
        });
        nextBtnSec.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "-50%";
            bullet[current - 1].classList.add("active");
            progressCheck[current - 1].classList.add("active");
            progressText[current - 1].classList.add("active");
            current += 1;
        });
        nextBtnThird.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "-75%";
            bullet[current - 1].classList.add("active");
            progressCheck[current - 1].classList.add("active");
            progressText[current - 1].classList.add("active");
            current += 1;
        });
        prevBtnSec.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "0%";
            bullet[current - 2].classList.remove("active");
            progressCheck[current - 2].classList.remove("active");
            progressText[current - 2].classList.remove("active");
            current -= 1;
        });
        prevBtnThird.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "-25%";
            bullet[current - 2].classList.remove("active");
            progressCheck[current - 2].classList.remove("active");
            progressText[current - 2].classList.remove("active");
            current -= 1;
        });
        prevBtnFourth.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "-50%";
            bullet[current - 2].classList.remove("active");
            progressCheck[current - 2].classList.remove("active");
            progressText[current - 2].classList.remove("active");
            current -= 1;
        });
        /* Slash/Unslash EyePSW */
        function _id(name) {
            return document.getElementById(name);
        }
        function _class(name) {
            return document.getElementsByClassName(name);
        }
        _class("toggle-password")[0].addEventListener("click", function () {
            _class("toggle-password")[0].classList.toggle("active");
            if (_id("password-field").getAttribute("type") == "password") {
                _id("password-field").setAttribute("type", "text");
            } else {
                _id("password-field").setAttribute("type", "password");
            }
        });
        /* Password Policy Validation */
        _id("password-field").addEventListener("focus", function () {
            _class("password-policies")[0].classList.add("active")
        });
        _id("password-field").addEventListener("blur", function () {
            _class("password-policies")[0].classList.remove("active")
        });
        _id("password-field").addEventListener("keyup", function () {
            let password = _id("password-field").value;
            if (/[A-Z]/.test(password)) {
                _class("policy-uppercase")[0].classList.add("active");
            } else {
                _class("policy-uppercase")[0].classList.remove("active");
            }
            if (/[0-9]/.test(password)) {
                _class("policy-number")[0].classList.add("active");
            } else {
                _class("policy-number")[0].classList.remove("active");
            }
            if (/[^A-Za-z0-9]/.test(password)) {
                _class("policy-special")[0].classList.add("active");
            } else {
                _class("policy-special")[0].classList.remove("active");
            }
            if (password.length > 7) {
                _class("policy-length")[0].classList.add("active");
            } else {
                _class("policy-length")[0].classList.remove("active");
            }
        });

/* Product Gallery */
const imgs = document.querySelectorAll('.img-select a');
const imgBtns = [...imgs];
let imgId = 1;

imgBtns.forEach((imgItem) => {
    imgItem.addEventListener('click', (event) => {
        event.preventDefault();
        imgId = imgItem.dataset.id;
        slideImage();
    });
});

function slideImage() {
    const displayWidth = document.querySelector('.img-showcase img:first-child').clientWidth;

    document.querySelector('.img-showcase').style.transform = `translateX(${-(imgId - 1) * displayWidth}px)`;
}

window.addEventListener('resize', slideImage);
