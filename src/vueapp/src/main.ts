import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { DataLoaderPlugin } from 'unplugin-vue-router/data-loaders'

const app = createApp(App)

app.use(DataLoaderPlugin, { router })
app.use(router)

app.mount('#app')
