
//singin
window.addEventListener('load', function() {
  auth0 = new Auth0({
    domain: 'newty12.auth0.com',
    clientID: 'VW4GtIVcSL5kQm2ZmwOEo3xfnF8LsbwY',
    callbackURL: 'https://YOUR_APP/callback',
    responseType: 'token'
  });
});

document.getElementById('btn-login').addEventListener('click', function() {
  var username = document.getElementById('username').value;
  var password = document.getElementById('password').value;
  auth0.login({
    connection: 'Username-Password-Authentication',
    responseType: 'token',
    email: username,
    password: password,
  }, function(err) {
    if (err) {
      alert("something went wrong: " + err.message);
    } else {
      show_logged_in(username);
    }
  });
});

var parseHash = function() {
  var token = localStorage.getItem('id_token');
  if (token) {
    show_logged_in();
  } else {
    var result = auth0.parseHash(window.location.hash);
    if (result && result.idToken) {
      localStorage.setItem('id_token', result.idToken);
      show_logged_in();
    } else if (result && result.error) {
      alert('error: ' + result.error);
      show_sign_in();
    }
  }
};

parseHash();

//singup

document.getElementById('btn-register').addEventListener('click', function() {
  var username = document.getElementById('username').value;
  var password = document.getElementById('password').value;
  auth0.signup({
    connection: 'Username-Password-Authentication',
    responseType: 'token',
    email: username,
    password: password,
  }, function(err) {
    if (err) alert("something went wrong: " + err.message);
  });
});

//add social login

document.getElementById('btn-google').addEventListener('click', function() {
  auth0.login({
    connection: 'google-oauth2'
  }, function(err) {
    if (err) alert("something went wrong: " + err.message);
  });
});
