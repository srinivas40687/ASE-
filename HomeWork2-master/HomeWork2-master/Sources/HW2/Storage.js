/**
 * Created by mahes on 2/1/2017.
 */
//function to store user name and password
function store(theForm) {
    document.getElementById('welcomeMessage').innerHTML = "";
    var inputUsername= theForm["name"];
    var inputUserdob= theForm["dob"];
    var inputUsermail= theForm["email"];
    var inputPassword= theForm["psw"];
    localStorage.setItem("username", inputUsername.value);
    localStorage.setItem("dateofbirth", inputUserdob.value);
    localStorage.setItem("useremail", inputUsermail.value);
    localStorage.setItem("password", inputPassword.value);
    document.getElementById('welcomeMessage').innerHTML = "Welcome " + localStorage.getItem('username') + "!";
    return false;
}

//function to sign in
function login(theForm) {
    document.getElementById('welcomeMessage').innerHTML = "";
    var inputUsername = theForm["uname"];
    var inputPassword = theForm["psw"];
    var username = inputUsername.value;
    var password = inputPassword.value;
    if ((username == localStorage.getItem('username')) && (password == localStorage.getItem('password'))) {
        document.getElementById('welcomeMessage').innerHTML = "Welcome " + localStorage.getItem('username') + "!";
    } else {
        document.getElementById('welcomeMessage').innerHTML = "Invalid Log-in!";
    }
    return false;
}