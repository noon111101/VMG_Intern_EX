<template>
    <div>
        <header class="s-header">
            <div class="header__top">
                <div class="header__logo">
                    <a class="site-logo" href="index.html">
                        <img src="../assets/images/logo.svg" alt="Homepage">
                    </a>
                </div>
            </div>
            <nav class="header__nav-wrap">
                <ul class="header__nav">
                    <li class="current"><a href="index.html" title="">Home</a></li>
                    <li class="has-children">
                        <a href="#0" title="">Categories</a>
                        <ul class="sub-menu">
                            <li><a href="category.html">Lifestyle</a></li>
                            <li><a href="category.html">Health</a></li>
                            <li><a href="category.html">Family</a></li>
                            <li><a href="category.html">Management</a></li>
                            <li><a href="category.html">Travel</a></li>
                            <li><a href="category.html">Work</a></li>
                        </ul>
                    </li>
                    <li class="has-children">
                        <a href="#0" title="">Blog Posts</a>
                        <ul class="sub-menu">
                            <li><a href="single-video.html">Video Post</a></li>
                            <li><a href="single-audio.html">Audio Post</a></li>
                            <li><a href="single-gallery.html">Gallery Post</a></li>
                            <li><a href="single-standard.html">Standard Post</a></li>
                        </ul>
                    </li>
                    <li><a href="styles.html" title="">Styles</a></li>
                    <li><a href="page-about.html" title="">About</a></li>
                    <li><a href="page-contact.html" title="">Contact</a></li>
                </ul> <!-- end header__nav -->
            
                <ul class="header__social">
                    <li class="ss-facebook">
                        <a href="https://facebook.com/">
                            <i class="icon bi bi-facebook"></i>
                        </a>
                    </li>
                    <li class="ss-twitter">
                        <a href="#0">
                            <i class="icon bi bi-twitter"></i>
                        </a>
                    </li>
                    <li class="ss-dribbble">
                        <a href="#0">
                            <i class="icon bi bi-dribbble"></i>
                        </a>
                    </li>
                    <li class="ss-pinterest">
                        <a href="#0">
                            <i class="icon bi bi-pinterest"></i>
                        </a>
                    </li>
                </ul>
            
            </nav>
        </header>
    </div>
</template>

<script>
export default {
    name: 'NavBlog',

    data() {
        return {
            
        };
    },

    mounted() {
        
    },

    methods: {
        
    },
};
</script>

<style scoped>

.s-wrap {
  position: relative;
}

.s-header {
  z-index: 100;
  display: -ms-flexbox;
  display: -webkit-flex;
  display: flex;
  -webkit-flex-flow: column nowrap;
  -ms-flex-flow: column nowrap;
  flex-flow: column nowrap;
  width: 300px;
  background-color: #151515;
  padding-top: 6.4rem;
  padding-right: 3.2rem;
  padding-left: 4.4rem;
  overflow-y: auto;
  overflow-x: hidden;
  vertical-align: top;
  position: fixed;
  bottom: 0;
  top: 0;
  left: 0;
}

/* -------------------------------------------------------------------
 * ## header logo
 * ------------------------------------------------------------------- */
.header__logo a {
  display: block;
  margin: 0;
  padding: 0;
  outline: 0;
  border: none;
  transition: all 0.3s;
}

.header__logo img {
  width: 125px;
  height: 30px;
  margin: 0;
}

/* -------------------------------------------------------------------
 * ## header main navigation
 * ------------------------------------------------------------------- */
.header__nav-wrap {
  display: -ms-flexbox;
  display: -webkit-flex;
  display: flex;
  -webkit-flex-flow: column nowrap;
  -ms-flex-flow: column nowrap;
  flex-flow: column nowrap;
  -webkit-flex: 1 1 0%;
  -ms-flex: 1 1 0%;
  flex: 1 1 0%;
  -ms-flex-pack: justify;
  -webkit-justify-content: space-between;
  justify-content: space-between;
  -webkit-align-items: stretch;
  -ms-flex-align: stretch;
  align-items: stretch;
  max-width: 100%;
  background-color: #151515;
  margin-top: 3.2rem;
}

.header__nav-wrap a {
  color: rgba(255, 255, 255, 0.6);
}

.header__nav {
  list-style: none;
  margin: 0;
  padding: 0;
  font-family: "Heebo", sans-serif;
  font-weight: 400;
  font-size: 16px;
}

.header__nav li {
  display: block;
  padding: 0 2rem 0 0;
  width: 100%;
  position: relative;
}

.header__nav li a {
  display: block;
  color: rgba(255, 255, 255, 0.6);
  line-height: 4.4rem;
}

.header__nav li.has-children {
  padding-right: 3.3rem;
}

.header__nav li.has-children > a::after {
  border-bottom: 1px solid rgba(255, 255, 255, 0.4);
  border-right: 1px solid rgba(255, 255, 255, 0.4);
  content: "";
  display: block;
  height: 5px;
  width: 5px;
  margin-top: -4px;
  pointer-events: none;
  position: absolute;
  right: 1.8rem;
  top: 21px;
  -webkit-transform-origin: 66% 66%;
  -ms-transform-origin: 66% 66%;
  transform-origin: 66% 66%;
  -webkit-transform: rotate(45deg);
  transform: rotate(45deg);
  transition: all 0.5s;
}

.header__nav li.has-children > a.sub-menu-is-open::after {
  -webkit-transform: rotate(225deg);
  transform: rotate(225deg);
}

.header__nav li:hover > a,
.header__nav li:focus > a {
  color: #ffffff;
}

.header__nav li:hover li,
.header__nav li:focus li {
  background: transparent;
}

.header__nav li.current > a {
  color: #ffffff;
}

.header__nav li ul {
  display: none;
  font-weight: 300;
  font-size: 11px;
  text-transform: uppercase;
  letter-spacing: 3px;
  margin: 0;
  padding: 0.8rem 0 2rem 1.2rem;
}

.header__nav li ul a {
  line-height: 3.2rem;
}
/* -------------------------------------------------------------------
 * ## header social
 * ------------------------------------------------------------------- */
 .header__social {
  list-style: none;
  margin: 4rem 0 0 0;
  padding: 0 0 4.4rem 0;
  display: -ms-flexbox;
  display: -webkit-flex;
  display: flex;
}

.header__social li {
  margin-right: 2px;
}

.header__social li:last-child {
  margin-right: 0;
}

.header__social a {
  display: block;
  background-color: rgba(255, 255, 255, 0.04);
  color: rgba(255, 255, 255, 0.5);
  height: 3.6rem;
  width: 3.6rem;
  border-radius: 50%;
  position: relative;
}

.header__social a::after {
  z-index: 1;
  content: "";
  display: block;
  height: 1.4rem;
  width: 1.4rem;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: contain;
  -webkit-transform: translate3d(-50%, -50%, 0);
  transform: translate3d(-50%, -50%, 0);
  transition: all 0.3s;
  position: absolute;
  left: 50%;
  right: 0;
  top: 50%;
}

.header__social a:hover::after {
  height: 1.8rem;
  width: 1.8rem;
}

.header__social span {
  clip: rect(1px, 1px, 1px, 1px);
  clip-path: inset(50%);
  height: 1px;
  width: 1px;
  margin: -1px;
  overflow: hidden;
  padding: 0;
  border: 0;
  position: absolute;
}



</style>