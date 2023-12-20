// Sélectionnez le bouton par son ID
const boutonReveAleatoire = document.getElementById("boutonReveAleatoire");

// Ajoutez un écouteur d'événement 'click' au bouton
boutonReveAleatoire.addEventListener('click', function() {
    // Effectuez une requête AJAX vers votre endpoint API
     fetch('/api/v1/dreamscape/findDream') // Remplacez '/dreams/random' par l'URL de votre endpoint API
    .then(response => {
        // Vérifiez si la réponse est OK (200)
        if (response.ok) {
            // Convertissez la réponse JSON en objet JavaScript
            return response.json();
        };
    })
    .then(data => {
        // Utilisez les données récupérées pour afficher le rêve dans la zone spécifiée
        const title = data["title"]
        const description = data["description"]
        const dateCreate = data["dateCreate"]

        const zoneAffichageReve = document.getElementById('zoneAffichageReve');
            zoneAffichageReve.innerHTML = title + "<br><br>" + description + "<br><br>" + dateCreate + "<br><br><br>";
        // Exemple d'affichage des données (remplacez par les champs réels de votre objet DreamDTO)
    })
    .catch(error => {
        // Gérez les erreurs
        console.error('Une erreur s\'est produite:', error);
    });
});

// Example starter JavaScript for disabling form submissions if there are invalid fields
    (function() {
      'use strict';

      window.addEventListener('load', function() {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');

        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function(form) {
          form.addEventListener('submit', function(event) {
            if (form.checkValidity() === false) {
              event.preventDefault();
              event.stopPropagation();
            }
            form.classList.add('was-validated');
          }, false);
        });
      }, false);
    })();

    document.getElementById("submitButton").addEventListener("click", function() {
        document.getElementById("myForm").action = "/showAllUsers";
        document.getElementById("myForm").submit();
        var result = document.getElementById("result");
        result.innerHTML("lol");
    });



