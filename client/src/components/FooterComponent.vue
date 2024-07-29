<template>

    <footer>
            
            <div id="footer-area">
                <a href="#"><img src="../assets/img/site-logo.png" alt="footer-site-logo"></a>
                <div class="footer-links">
                    <ul>
                        <li><h3>Social</h3></li>
                        <hr>
                        <li><a href="#">LinkedIn</a></li>
                        <li><a href="#">GitHub</a></li>
                    </ul>
                </div>
                <div class="footer-links">
                    <ul>
                        <li><h3>Information</h3></li>
                        <hr>
                        <li><a href="#">About</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                </div>
            </div>

            <p id="copyright"><span>©</span> 2024 Copyright Justin Wahkwai Wong. All rights reserved</p>
    
        </footer>
    
</template>

<script>
export default {

}


</script>

<style>
footer {
    background-color: #6666ff;
    min-height: 100px;
    padding: 20px;
    color: white;
    
}

footer li {
    list-style: none;
}

footer li a {
    text-decoration: none;
}

footer li a:hover {
    color: rgb(26, 23, 118);
}

footer img {
    width: 300px;
}

#footer-area {
    display: flex;
    justify-content: center;
    column-gap: 5rem;
    align-items: flex-start;
}

.footer-links h3 {
    margin-bottom: 0;
}

.footer-links hr {
    width: 200px;
}

#copyright {
    text-align: center;
}

#copyright span {
    font-family: 'Courier New', Courier, monospace;
    font-size: 1.25rem;
}

.dark-mode {
    footer {
      background-color: #0b041a;
    }
}

</style>