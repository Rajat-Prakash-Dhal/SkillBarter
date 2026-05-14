# SkillBarter 🤝
### Exchange Skills. Build Community.

SkillBarter is a community-driven Android application designed to facilitate the non-monetary exchange of services. It enables users to leverage their personal expertise—from coding to carpentry—in exchange for help they need, fostering mutual aid without financial barriers.

---

## 🚀 Problem Statement
In many urban and local communities, residents possess valuable skills but lack an efficient, non-monetary way to share them. Existing marketplaces are currency-dependent, which can be a barrier for students and freshers. **SkillBarter** bridges this gap by creating a "barter economy" where time and talent are the primary denominations, helping users build a local support network while saving costs.

## 🛠 Tech Stack
* **Language:** Kotlin
* **UI Framework:** Jetpack Compose (Material Design 3)
* **Navigation:** Compose Navigation
* **Backend:**
    * **Firebase Authentication:** Secure user onboarding and session management.
    * **Cloud Firestore:** Real-time database for managing skill posts and the **Skill Point Exchange** system.
* **Architecture:** Reactive State Management with Coroutines & Flow.
* **Localization:** Built-in support for **English** and **Kannada**.

## ✨ Key Features
* **Skill Point Exchange:** Integrated point tracking system via Firestore. Earn points for every successful swap to build your community reputation.
* **Smart Marketplace:** Filterable categories (Plumbing, Electrical, Tech, etc.) with a "Needs vs. Offers" toggle system.
* **Real-time Communication:** Built-in private chat for negotiating swap details and timing.
* **AI Support Bot:** An integrated automated assistant to help users understand swap guidelines and app safety.
* **Verified Profiles:** Trust-building mechanism through identity verification badges and user ratings.

---

## 📐 Architecture
The app follows a modern declarative UI approach where the UI state is reactively driven by Firebase data.



---

## 📂 Project Structure
* `MainActivity.kt`: The main entry point and Navigation Host.
* `data/FirebaseManager.kt`: Logic for Firebase Auth and Firestore point transactions.
* `ui/theme/`: Custom Design Tokens (Amber & Teal palette) and Material 3 shapes.
* `ui/screens/`: 
    * `ExploreScreen.kt`: Multi-select filtering and search logic.
    * `ChatScreen.kt`: Real-time messaging interface.
    * `ProfileScreen.kt`: User statistics and point management.

---

## 🛠 Installation & Setup
1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/Rajat-Prakash-Dhal/SkillBarter.git](https://github.com/Rajat-Prakash-Dhal/SkillBarter.git)
    ```
2.  **Firebase Configuration:**
    * Create a project in the [Firebase Console](https://console.firebase.google.com/).
    * Download your `google-services.json` and place it in the `app/` folder.
    * Enable **Email/Password Auth** and **Cloud Firestore**.
3.  **Firestore Rules:** Ensure your rules allow authenticated users to read/write to the `users` and `posts` collections.
4.  **Run:** Open the project in Android Studio (Hedgehog or later) and run on a device/emulator.

---
*Developed by Rajat Prakash Dhal as part of a Technology Portfolio.*
