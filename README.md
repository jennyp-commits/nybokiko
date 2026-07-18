# 📱 Trano Boky — Application Android
## Filazantsara Miako · FJKM Masobe · Masobe, Itasy, Madagascar

Application Android de bibliothèque numérique — Wrapper Capacitor de la PWA Trano Boky.

---

## 🚀 Générer l'APK (3 méthodes)

### Méthode 1 — GitHub Actions (RECOMMANDÉE · Zéro installation)

1. Créer un compte GitHub : https://github.com/signup
2. Créer un nouveau dépôt : https://github.com/new (nom : `trano-boky-app`)
3. Pousser ce projet sur le dépôt
4. Aller dans **Actions** → le build démarre automatiquement
5. Après ~5 minutes → télécharger `trano-boky-debug.apk` dans **Artifacts**

```bash
# Commandes Git (après avoir créé le dépôt sur GitHub)
git init
git add .
git commit -m "Initial Trano Boky Android app"
git remote add origin https://github.com/VOTRE_USERNAME/trano-boky-app.git
git push -u origin main
```

### Méthode 2 — Android Studio (sur votre PC)

1. Installer Android Studio : https://developer.android.com/studio
2. Ouvrir ce dossier dans Android Studio → ouvrir le dossier `android/`
3. Menu **Build → Build Bundle(s)/APK(s) → Build APK(s)**
4. APK généré dans `android/app/build/outputs/apk/debug/`

### Méthode 3 — Codemagic CI/CD (gratuit · 500 min/mois)

1. Créer un compte : https://codemagic.io
2. Connecter votre dépôt GitHub
3. Cliquer **Start new build**
4. APK téléchargeable en ~8 minutes

---

## ⚙️ Configuration avant build

### 1. Renseigner les clés Supabase + PocketBase

Modifier `www/index.html` (section CONFIG) :
```javascript
const CFG = {
  DEMO_MODE: false,           // ← passer à false
  SB_URL:    'https://XXXXXXXX.supabase.co',
  SB_ANON:   'eyJhbGci...',
  PB_URL:    'http://VOTRE_IP_ORACLE:8090',
};
```

### 2. Mettre à jour l'IP Oracle dans network_security_config.xml

```xml
<!-- android/app/src/main/res/xml/network_security_config.xml -->
<domain includeSubdomains="false">VOTRE_IP_ORACLE</domain>
```

### 3. Synchroniser après modifications

```bash
npx cap sync android
```

---

## 📲 Installer l'APK sur Android

1. Copier `app-debug.apk` sur le téléphone (WhatsApp, email, câble USB)
2. Sur Android : **Paramètres → Sécurité → Sources inconnues → Activer**
3. Ouvrir le fichier APK → **Installer**
4. L'icône Trano Boky apparaît dans le lanceur

### Appareils compatibles
- Android 7.0 (Nougat) et supérieur
- Testé sur : Samsung Galaxy A, Tecno Spark, Itel P40

---

## 📦 Structure du projet

```
trano-boky-app/
├── www/
│   └── index.html          ← Application web (client.html renommé)
├── android/                ← Projet Android natif
│   ├── app/src/main/
│   │   ├── AndroidManifest.xml
│   │   ├── java/mg/fjkm/.../MainActivity.java
│   │   └── res/
│   │       ├── values/colors.xml
│   │       ├── values/strings.xml
│   │       ├── values/styles.xml
│   │       ├── xml/network_security_config.xml
│   │       └── mipmap-*/ic_launcher.png
├── .github/workflows/
│   └── build-apk.yml       ← Build automatique GitHub Actions
├── capacitor.config.ts     ← Configuration Capacitor
└── package.json
```

---

## 🏪 Publication sur Google Play Store (optionnel)

1. Créer un compte développeur Google Play : https://play.google.com/console ($25 unique)
2. Générer un keystore de signature :
```bash
keytool -genkey -v -keystore trano-boky.keystore \
  -alias trano-boky -keyalg RSA -keysize 2048 -validity 10000
```
3. Encoder en base64 pour GitHub Secrets :
```bash
base64 -w 0 trano-boky.keystore > keystore.b64
```
4. Dans GitHub → Settings → Secrets → ajouter : `KEYSTORE_BASE64`, `KEY_ALIAS`, `KEY_PASSWORD`, `STORE_PASSWORD`
5. Le workflow `build-release` génère automatiquement l'APK signé

---

## 🔧 Plugins Capacitor intégrés

| Plugin | Fonctionnalité |
|---|---|
| @capacitor/push-notifications | Notifications push natives |
| @capacitor/haptics | Vibration (confirmation paiement) |
| @capacitor/status-bar | Barre de statut bleue (#039BE5) |
| @capacitor/splash-screen | Écran de démarrage |

---

*Trano Boky v2.0 · Architecture Supabase + PocketBase + Capacitor*  
*© Filazantsara Miako Édisiona · FJKM Masobe · Soli Deo Gloria*
# nybokiko
