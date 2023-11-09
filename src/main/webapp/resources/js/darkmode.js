const butmobile = document.getElementById('button_mob');
function Menutoggle(){
    const nav = document.getElementById('nav');
    nav.classList.toggle('active');
}

butmobile.addEventListener("click", Menutoggle);
//darkmode
const html = document.querySelector('html')
const chk = document.getElementById('chk')

chk.addEventListener('change',function(){
   html.classList.toggle('dark')
})