# Spring Vue Demo

## Steps to build/run

* Install Java 21, Maven
* Install npm
* In directory src/vueapp, execute `npm install`

In case you want to create your own Vue projects, install the Vue command line tool: `npm install -g @vue/cli`.

Build complete project: `mvn clean package`.

### How to start

* Spring part: Start the class de.codecentric.vue.VueDemoWithSpringBootApplication in your Java IDE,
  you can use --spring.profiles.active=ide to activate additional property file application-ide.yaml
* Vue part: In you shell, navigate to src/vueapp, then start with `npm run dev`

Open in Browser: [Start app](http://localhost:5173/)

## Further reading

* Part 1 of blog post: [German](https://www.codecentric.de/wissens-hub/blog/spring-und-vue-ein-setup-fuer-kleine-projekte-teil-1) and [English](https://www.codecentric.de/wissens-hub/blog/spring-and-vue-a-setup-for-small-projects-part-1) (Available Jan 10, 2025)
* Part 2 of blog post: [German](https://www.codecentric.de/wissens-hub/blog/spring-und-vue-ein-setup-fuer-kleine-projekte-teil-2) and [English](https://www.codecentric.de/wissens-hub/blog/spring-and-vue-a-setup-for-small-projects-part-2) (Available Jan 17, 2025)

* Similar setup, but uglier bookmarks: [spring-boot-vuejs](https://github.com/jonashackt/spring-boot-vuejs)
* [Dev-Tools for Chrome](https://chrome.google.com/webstore/detail/vuejs-devtools/ljjemllljcmogpfapbkkighbhhppjdbg)
* Plugin in VScode, can be installed via plugin manager

* Styling: [Tailwind CSS](https://tailwindcss.com)
* Component Library for Tailwind CSS: [Daisyui](https://daisyui.com)

