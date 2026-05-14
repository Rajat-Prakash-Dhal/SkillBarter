package com.example.skillbarter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.*

// ── Design Tokens ────────────────────────────────────────────────────────────

val BgDeep       = Color(0xFF0F1117)
val BgCard       = Color(0xFF1A1D27)
val BgElevated   = Color(0xFF22263A)
val AccentAmber  = Color(0xFFF59E0B)
val AccentTeal   = Color(0xFF14B8A6)
val AccentRed    = Color(0xFFF87171)
val TextPrimary  = Color(0xFFF1F5F9)
val TextSecondary= Color(0xFF94A3B8)
val TextMuted    = Color(0xFF475569)
val Divider      = Color(0xFF1E2236)
val OnlineGreen  = Color(0xFF22C55E)

// ── Language Support ─────────────────────────────────────────────────────────

enum class AppLanguage { ENGLISH, KANNADA }

data class Strings(
    val appName: String,
    val appTagline: String,
    val login: String,
    val signUp: String,
    val logIn: String,
    val email: String,
    val emailPlaceholder: String,
    val password: String,
    val passwordPlaceholder: String,
    val forgotPassword: String,
    val createAccount: String,
    val continueAsGuest: String,
    val privacyNote: String,
    val orContinueWith: String,
    val fullName: String,
    val yourName: String,
    val goodDay: String,
    val searchPlaceholder: String,
    val activeSwaps: String,
    val nearYou: String,
    val yourPosts: String,
    val swapsAvailable: String,
    val save: String,
    val startSwap: String,
    val explore: String,
    val exploreSubtitle: String,
    val searchBySkill: String,
    val results: String,
    val createSwap: String,
    val createSwapSubtitle: String,
    val whatDoYouNeed: String,
    val needPlaceholder: String,
    val whatDoYouOffer: String,
    val offerPlaceholder: String,
    val category: String,
    val publishSwap: String,
    val postPublished: String,
    val messages: String,
    val onlineNow: String,
    val activeNow: String,
    val recent: String,
    val profile: String,
    val skillPoints: String,
    val swapsDone: String,
    val rating: String,
    val mySkills: String,
    val account: String,
    val editProfile: String,
    val notifications: String,
    val language: String,
    val preferences: String,
    val securityPrivacy: String,
    val theme: String,
    val support: String,
    val helpCenter: String,
    val contactUs: String,
    val privacyPolicy: String,
    val communityReviews: String,
    val signOut: String,
    val noSwapsFound: String,
    val tryDifferentSearch: String,
    val noResults: String,
    val tryAdjusting: String,
    val online: String,
    val verified: String,
    val swaps: String,
    val needs: String,
    val offers: String,
    val messagePlaceholder: String,
    val all: String,
    val plumbing: String,
    val electrical: String,
    val carpentry: String,
    val painting: String,
    val bikeRepair: String,
    val acService: String,
    val other: String,
    val general: String,
    val home: String,
    val post: String,
    val chat: String,
    val skillBarterMember: String,
    val changePhoto: String,
    val chooseAvatar: String,
    val needsFilter: String,
    val offersFilter: String
)

val EnglishStrings = Strings(
    appName = "SkillBarter",
    appTagline = "Exchange skills. Build community.",
    login = "Log In",
    signUp = "Sign Up",
    logIn = "Log In",
    email = "Email",
    emailPlaceholder = "you@example.com",
    password = "Password",
    passwordPlaceholder = "••••••••",
    forgotPassword = "Forgot password?",
    createAccount = "Create Account",
    continueAsGuest = "Continue as Guest",
    privacyNote = "Your privacy is our priority. 🔒",
    orContinueWith = "or continue with",
    fullName = "Full Name",
    yourName = "Your name",
    goodDay = "Good day, Rajat 👋",
    searchPlaceholder = "Search skills, people...",
    activeSwaps = "Active Swaps",
    nearYou = "Near You",
    yourPosts = "Your Posts",
    swapsAvailable = "swaps available",
    save = "Save",
    startSwap = "Start Swap",
    explore = "Explore",
    exploreSubtitle = "Discover skill swaps near you",
    searchBySkill = "Search by name or skill...",
    results = "results",
    createSwap = "Create a Swap",
    createSwapSubtitle = "Post what you need and what you offer",
    whatDoYouNeed = "What do you need?",
    needPlaceholder = "e.g. Plumbing help in kitchen",
    whatDoYouOffer = "What do you offer?",
    offerPlaceholder = "e.g. Electrical wiring work",
    category = "Category",
    publishSwap = "Publish Swap Post",
    postPublished = "Your swap post was published!",
    messages = "Messages",
    onlineNow = "online now",
    activeNow = "Active Now",
    recent = "Recent",
    profile = "Profile",
    skillPoints = "Skill Points",
    swapsDone = "Swaps Done",
    rating = "Rating",
    mySkills = "My Skills",
    account = "Account",
    editProfile = "Edit Profile",
    notifications = "Notifications",
    language = "Language",
    preferences = "Preferences",
    securityPrivacy = "Security & Privacy",
    theme = "Theme",
    support = "Support",
    helpCenter = "Help Center",
    contactUs = "Contact Us",
    privacyPolicy = "Privacy Policy",
    communityReviews = "Community Reviews",
    signOut = "Sign Out",
    noSwapsFound = "No skill swaps found",
    tryDifferentSearch = "Try a different search or category",
    noResults = "No results found",
    tryAdjusting = "Try adjusting your search or category filter",
    online = "Online",
    verified = "Verified",
    swaps = "swaps done",
    needs = "NEEDS",
    offers = "OFFERS",
    messagePlaceholder = "Message...",
    all = "All",
    plumbing = "Plumbing",
    electrical = "Electrical",
    carpentry = "Carpentry",
    painting = "Painting",
    bikeRepair = "Bike Repair",
    acService = "AC Service",
    other = "Other",
    general = "General",
    home = "Home",
    post = "Post",
    chat = "Chat",
    skillBarterMember = "SkillBarter Member",
    changePhoto = "Change Photo",
    chooseAvatar = "Choose Avatar",
    needsFilter = "Needs",
    offersFilter = "Offers"
)

val KannadaStrings = Strings(
    appName = "SkillBarter",
    appTagline = "ಕೌಶಲ್ಯ ವಿನಿಮಯ. ಸಮುದಾಯ ನಿರ್ಮಾಣ.",
    login = "ಲಾಗಿನ್",
    signUp = "ನೋಂದಣಿ",
    logIn = "ಲಾಗಿನ್",
    email = "ಇಮೇಲ್",
    emailPlaceholder = "you@example.com",
    password = "ಪಾಸ್‌ವರ್ಡ್",
    passwordPlaceholder = "••••••••",
    forgotPassword = "ಪಾಸ್‌ವರ್ಡ್ ಮರೆತಿದ್ದೀರಾ?",
    createAccount = "ಖಾತೆ ತೆರೆಯಿರಿ",
    continueAsGuest = "ಅತಿಥಿಯಾಗಿ ಮುಂದುವರಿಯಿರಿ",
    privacyNote = "ನಿಮ್ಮ ಗೌಪ್ಯತೆ ನಮ್ಮ ಆದ್ಯತೆ. 🔒",
    orContinueWith = "ಅಥವಾ ಇದರ ಮೂಲಕ ಮುಂದುವರಿಯಿರಿ",
    fullName = "ಪೂರ್ಣ ಹೆಸರು",
    yourName = "ನಿಮ್ಮ ಹೆಸರು",
    goodDay = "ಶುಭ ದಿನ, ರಾಜತ್ 👋",
    searchPlaceholder = "ಕೌಶಲ್ಯ, ಜನರನ್ನು ಹುಡುಕಿ...",
    activeSwaps = "ಸಕ್ರಿಯ ವಿನಿಮಯ",
    nearYou = "ಹತ್ತಿರದಲ್ಲಿ",
    yourPosts = "ನಿಮ್ಮ ಪೋಸ್ಟ್",
    swapsAvailable = "ವಿನಿಮಯ ಲಭ್ಯ",
    save = "ಉಳಿಸಿ",
    startSwap = "ವಿನಿಮಯ ಪ್ರಾರಂಭ",
    explore = "ಅನ್ವೇಷಿಸಿ",
    exploreSubtitle = "ಹತ್ತಿರದ ಕೌಶಲ್ಯ ವಿನಿಮಯ ಕಂಡುಹಿಡಿಯಿರಿ",
    searchBySkill = "ಹೆಸರು ಅಥವಾ ಕೌಶಲ್ಯದಿಂದ ಹುಡುಕಿ...",
    results = "ಫಲಿತಾಂಶಗಳು",
    createSwap = "ವಿನಿಮಯ ರಚಿಸಿ",
    createSwapSubtitle = "ನಿಮಗೆ ಏನು ಬೇಕು ಮತ್ತು ನೀವು ಏನು ನೀಡುತ್ತೀರಿ ಎಂದು ಪ್ರಕಟಿಸಿ",
    whatDoYouNeed = "ನಿಮಗೆ ಏನು ಬೇಕು?",
    needPlaceholder = "ಉದಾ. ಅಡಿಗೆ ಮನೆಯಲ್ಲಿ ಪ್ಲಂಬಿಂಗ್ ಸಹಾಯ",
    whatDoYouOffer = "ನೀವು ಏನು ನೀಡುತ್ತೀರಿ?",
    offerPlaceholder = "ಉದಾ. ವಿದ್ಯುತ್ ತಂತಿ ಕೆಲಸ",
    category = "ವರ್ಗ",
    publishSwap = "ವಿನಿಮಯ ಪ್ರಕಟಿಸಿ",
    postPublished = "ನಿಮ್ಮ ವಿನಿಮಯ ಪ್ರಕಟಿಸಲಾಗಿದೆ!",
    messages = "ಸಂದೇಶಗಳು",
    onlineNow = "ಈಗ ಆನ್‌ಲೈನ್",
    activeNow = "ಈಗ ಸಕ್ರಿಯ",
    recent = "ಇತ್ತೀಚಿನ",
    profile = "ಪ್ರೊಫೈಲ್",
    skillPoints = "ಕೌಶಲ್ಯ ಅಂಕಗಳು",
    swapsDone = "ವಿನಿಮಯ ಮಾಡಿದ",
    rating = "ರೇಟಿಂಗ್",
    mySkills = "ನನ್ನ ಕೌಶಲ್ಯಗಳು",
    account = "ಖಾತೆ",
    editProfile = "ಪ್ರೊಫೈಲ್ ಸಂಪಾದಿಸಿ",
    notifications = "ಅಧಿಸೂಚನೆಗಳು",
    language = "ಭಾಷೆ",
    preferences = "ಆದ್ಯತೆಗಳು",
    securityPrivacy = "ಭದ್ರತೆ ಮತ್ತು ಗೌಪ್ಯತೆ",
    theme = "ಥೀಮ್",
    support = "ಬೆಂಬಲ",
    helpCenter = "ಸಹಾಯ ಕೇಂದ್ರ",
    contactUs = "ನಮ್ಮನ್ನು ಸಂಪರ್ಕಿಸಿ",
    privacyPolicy = "ಗೌಪ್ಯತಾ ನೀತಿ",
    communityReviews = "ಸಮುದಾಯ ವಿಮರ್ಶೆಗಳು",
    signOut = "ಸೈನ್ ಔಟ್",
    noSwapsFound = "ಯಾವುದೇ ಕೌಶಲ್ಯ ವಿನಿಮಯ ಕಂಡುಬಂದಿಲ್ಲ",
    tryDifferentSearch = "ಬೇರೆ ಹುಡುಕಾಟ ಅಥವಾ ವರ್ಗ ಪ್ರಯತ್ನಿಸಿ",
    noResults = "ಯಾವುದೇ ಫಲಿತಾಂಶ ಕಂಡುಬಂದಿಲ್ಲ",
    tryAdjusting = "ನಿಮ್ಮ ಹುಡುಕಾಟ ಅಥವಾ ವರ್ಗ ಫಿಲ್ಟರ್ ಸರಿಹೊಂದಿಸಿ",
    online = "ಆನ್‌ಲೈನ್",
    verified = "ಪರಿಶೀಲಿಸಲಾಗಿದೆ",
    swaps = "ವಿನಿಮಯ ಮಾಡಿದ",
    needs = "ಬೇಕು",
    offers = "ನೀಡುತ್ತಾರೆ",
    messagePlaceholder = "ಸಂದೇಶ...",
    all = "ಎಲ್ಲಾ",
    plumbing = "ಪ್ಲಂಬಿಂಗ್",
    electrical = "ವಿದ್ಯುತ್",
    carpentry = "ಮರಗೆಲಸ",
    painting = "ಬಣ್ಣ ಹಚ್ಚುವಿಕೆ",
    bikeRepair = "ಬೈಕ್ ರಿಪೇರಿ",
    acService = "AC ಸೇವೆ",
    other = "ಇತರೆ",
    general = "ಸಾಮಾನ್ಯ",
    home = "ಮನೆ",
    post = "ಪೋಸ್ಟ್",
    chat = "ಚಾಟ್",
    skillBarterMember = "SkillBarter ಸದಸ್ಯ",
    changePhoto = "ಫೋಟೋ ಬದಲಿಸಿ",
    chooseAvatar = "ಅವತಾರ ಆಯ್ಕೆ ಮಾಡಿ",
    needsFilter = "ಬೇಕು",
    offersFilter = "ನೀಡುತ್ತಾರೆ"
)

// ── Data Models ──────────────────────────────────────────────────────────────

data class SkillPost(
    val name: String,
    val need: String,
    val offer: String,
    val category: String = "",
    val rating: Float = 4.5f,
    val swaps: Int = 0
)

data class ChatMessage(
    val sender: String,
    val message: String,
    val time: String = ""
)

data class ChatUser(
    val name: String,
    val lastMessage: String,
    val time: String,
    val online: Boolean,
    val unread: Int = 0
)

data class NavItem(
    val label: String,
    val route: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector
)

// ── App-level state ───────────────────────────────────────────────────────────

data class UserProfile(
    val name: String = "Rajat Kumar",
    val title: String = "Android Developer",
    val location: String = "Bengaluru",
    val phone: String = "+91 98765 43210",
    val bio: String = "Passionate developer who loves skill exchange!",
    // Stores the selected avatar emoji; empty string means show initials
    val avatarEmoji: String = ""
)

// ── Entry Point ───────────────────────────────────────────────────────────────

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { SkillBarterApp() }
    }
}

// ── App Shell ─────────────────────────────────────────────────────────────────

@Composable
fun SkillBarterApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    var currentLanguage by remember { mutableStateOf(AppLanguage.ENGLISH) }
    val strings = if (currentLanguage == AppLanguage.ENGLISH) EnglishStrings else KannadaStrings

    // Global app state
    var isDarkTheme by remember { mutableStateOf(true) }
    var userProfile by remember { mutableStateOf(UserProfile()) }
    var notificationVolume by remember { mutableStateOf(0.7f) }
    var notificationCount by remember { mutableStateOf(0) }

    val hiddenRoutes = setOf("login", "privateChat/{userName}")
    val showBottomBar = hiddenRoutes.none { currentRoute?.startsWith(it.substringBefore("{")) == true }

    val postList = remember {
        mutableStateListOf(
            SkillPost("Ramesh K.", "Needs Plumbing Repair", "Offers Electrical Work", "Plumbing", 4.8f, 12),
            SkillPost("Suresh M.", "Needs Carpentry Work",  "Offers Bike Repair",     "Carpentry", 4.5f, 7),
            SkillPost("Anil P.",   "Needs House Painting",  "Offers AC Service",      "Painting",  4.9f, 20),
            SkillPost("Kiran D.",  "Needs Electrical Fix",  "Offers Plumbing Help",   "Electrical",4.3f, 5),
            SkillPost("Meena S.", "Needs Bike Repair",      "Offers Carpentry Work",  "Bike Repair",4.7f, 9)
        )
    }

    MaterialTheme(
        colorScheme = if (isDarkTheme) darkColorScheme(
            background = BgDeep,
            surface = BgCard,
            primary = AccentAmber,
            onPrimary = BgDeep,
            onBackground = TextPrimary,
            onSurface = TextPrimary
        ) else lightColorScheme(
            background = Color(0xFFF8F9FA),
            surface = Color(0xFFFFFFFF),
            primary = AccentAmber,
            onPrimary = Color(0xFF1A1D27),
            onBackground = Color(0xFF1A1D27),
            onSurface = Color(0xFF1A1D27)
        )
    ) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            bottomBar = {
                if (showBottomBar) BottomNavigationBar(navController, currentRoute, strings, isDarkTheme, notificationCount)
            }
        ) { padding ->
            NavHost(
                navController = navController,
                startDestination = "login",
                modifier = Modifier.padding(padding)
            ) {
                composable("login") {
                    LoginScreen(strings) { navController.navigate("home") { popUpTo("login") { inclusive = true } } }
                }
                composable("home") {
                    HomeScreen(postList, navController, strings, isDarkTheme) {
                        notificationCount++
                    }
                }
                composable("explore") {
                    ExploreScreen(postList, navController, strings)
                }
                composable("add") {
                    AddPostScreen(postList, strings) {
                        notificationCount++
                    }
                }
                composable("chat") {
                    ChatScreen(navController, strings)
                }
                composable("profile") {
                    ProfileScreen(
                        strings = strings,
                        currentLanguage = currentLanguage,
                        onLanguageChange = { lang -> currentLanguage = lang },
                        isDarkTheme = isDarkTheme,
                        onThemeChange = { isDarkTheme = it },
                        userProfile = userProfile,
                        onProfileUpdate = { userProfile = it },
                        notificationVolume = notificationVolume,
                        onVolumeChange = { notificationVolume = it },
                        notificationCount = notificationCount,
                        onClearNotifications = { notificationCount = 0 },
                        onSignOut = {
                            navController.navigate("login") {
                                popUpTo(0) { inclusive = true }
                            }
                        }
                    )
                }
                composable("privateChat/{userName}") { back ->
                    val userName = back.arguments?.getString("userName") ?: "User"
                    PrivateChatScreen(userName, navController, strings) {
                        notificationCount++
                    }
                }
            }
        }
    }
}

// ── Bottom Navigation ─────────────────────────────────────────────────────────

@Composable
fun BottomNavigationBar(
    navController: NavController,
    currentRoute: String?,
    strings: Strings,
    isDarkTheme: Boolean,
    notificationCount: Int
) {
    val navItems = listOf(
        NavItem(strings.home,    "home",    Icons.Outlined.Home,          Icons.Filled.Home),
        NavItem(strings.explore, "explore", Icons.Outlined.Explore,       Icons.Filled.Explore),
        NavItem(strings.post,    "add",     Icons.Outlined.AddCircle,     Icons.Filled.AddCircle),
        NavItem(strings.chat,    "chat",    Icons.Outlined.ChatBubble,    Icons.Filled.ChatBubble),
        NavItem(strings.profile, "profile", Icons.Outlined.AccountCircle, Icons.Filled.AccountCircle)
    )

    val barBg = if (isDarkTheme) BgCard else Color(0xFFFFFFFF)

    Surface(
        color = barBg,
        shadowElevation = 24.dp,
        tonalElevation = 0.dp
    ) {
        NavigationBar(
            containerColor = barBg,
            tonalElevation = 0.dp,
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .height(64.dp)
        ) {
            navItems.forEach { item ->
                val selected = currentRoute == item.route
                NavigationBarItem(
                    selected = selected,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo("home") { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Box {
                            Icon(
                                imageVector = if (selected) item.selectedIcon else item.icon,
                                contentDescription = item.label,
                                modifier = Modifier.size(22.dp)
                            )
                            if (item.route == "profile" && notificationCount > 0) {
                                Box(
                                    modifier = Modifier
                                        .size(14.dp)
                                        .clip(CircleShape)
                                        .background(AccentRed)
                                        .align(Alignment.TopEnd),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        if (notificationCount > 9) "9+" else "$notificationCount",
                                        color = Color.White,
                                        fontSize = 7.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    },
                    label = {
                        Text(
                            item.label,
                            fontSize = 10.sp,
                            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
                            maxLines = 1
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = AccentAmber,
                        selectedTextColor = AccentAmber,
                        unselectedIconColor = TextMuted,
                        unselectedTextColor = TextMuted,
                        indicatorColor = AccentAmber.copy(alpha = 0.15f)
                    )
                )
            }
        }
    }
}

// ── Login Screen ──────────────────────────────────────────────────────────────

@Composable
fun LoginScreen(strings: Strings, onLogin: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPass by remember { mutableStateOf(false) }
    var isSignUp by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BgDeep)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .background(
                    Brush.verticalGradient(
                        listOf(AccentAmber.copy(alpha = 0.08f), Color.Transparent)
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(28.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(AccentAmber),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Filled.SwapHoriz, contentDescription = null, tint = BgDeep, modifier = Modifier.size(36.dp))
            }

            Spacer(Modifier.height(20.dp))

            Text(strings.appName, fontSize = 38.sp, fontWeight = FontWeight.Black, color = TextPrimary, letterSpacing = (-1).sp)
            Text(strings.appTagline, color = TextSecondary, fontSize = 15.sp)

            Spacer(Modifier.height(48.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(BgCard)
                    .padding(4.dp)
            ) {
                listOf(strings.logIn, strings.signUp).forEachIndexed { i, label ->
                    val sel = (i == 1) == isSignUp
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(11.dp))
                            .background(if (sel) AccentAmber else Color.Transparent)
                            .clickable { isSignUp = i == 1 }
                            .padding(vertical = 12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(label, fontWeight = FontWeight.SemiBold, color = if (sel) BgDeep else TextSecondary, fontSize = 15.sp)
                    }
                }
            }

            Spacer(Modifier.height(28.dp))

            if (isSignUp) {
                DarkTextField(strings.fullName, Icons.Default.Person, strings.yourName)
                Spacer(Modifier.height(14.dp))
            }

            Text(strings.email, color = TextSecondary, fontSize = 13.sp, fontWeight = FontWeight.Medium)
            Spacer(Modifier.height(6.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(strings.emailPlaceholder, color = TextMuted) },
                leadingIcon = { Icon(Icons.Default.Email, null, tint = TextMuted) },
                shape = RoundedCornerShape(14.dp),
                colors = darkFieldColors(),
                singleLine = true
            )

            Spacer(Modifier.height(14.dp))

            Text(strings.password, color = TextSecondary, fontSize = 13.sp, fontWeight = FontWeight.Medium)
            Spacer(Modifier.height(6.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(strings.passwordPlaceholder, color = TextMuted) },
                leadingIcon = { Icon(Icons.Default.Lock, null, tint = TextMuted) },
                trailingIcon = {
                    IconButton(onClick = { showPass = !showPass }) {
                        Icon(if (showPass) Icons.Default.VisibilityOff else Icons.Default.Visibility, null, tint = TextMuted)
                    }
                },
                visualTransformation = if (showPass) VisualTransformation.None else PasswordVisualTransformation(),
                shape = RoundedCornerShape(14.dp),
                colors = darkFieldColors(),
                singleLine = true
            )

            if (!isSignUp) {
                Spacer(Modifier.height(8.dp))
                Text(
                    strings.forgotPassword,
                    color = AccentAmber,
                    fontSize = 13.sp,
                    modifier = Modifier.align(Alignment.End)
                )
            }

            Spacer(Modifier.height(28.dp))

            Button(
                onClick = onLogin,
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = AccentAmber)
            ) {
                Text(
                    if (isSignUp) strings.createAccount else strings.logIn,
                    color = BgDeep,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(modifier = Modifier.weight(1f), color = BgElevated)
                Text("  ${strings.orContinueWith}  ", color = TextMuted, fontSize = 12.sp)
                HorizontalDivider(modifier = Modifier.weight(1f), color = BgElevated)
            }

            Spacer(Modifier.height(16.dp))

            OutlinedButton(
                onClick = onLogin,
                modifier = Modifier.fillMaxWidth().height(52.dp),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, BgElevated)
            ) {
                Icon(Icons.Default.AccountCircle, null, tint = TextSecondary, modifier = Modifier.size(20.dp))
                Spacer(Modifier.width(10.dp))
                Text(strings.continueAsGuest, color = TextSecondary, fontWeight = FontWeight.Medium)
            }

            Spacer(Modifier.height(24.dp))
            Text(
                strings.privacyNote,
                color = TextMuted,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun DarkTextField(label: String, icon: ImageVector, placeholder: String) {
    Column {
        Text(label, color = TextSecondary, fontSize = 13.sp, fontWeight = FontWeight.Medium)
        Spacer(Modifier.height(6.dp))
        var value by remember { mutableStateOf("") }
        OutlinedTextField(
            value = value,
            onValueChange = { value = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(placeholder, color = TextMuted) },
            leadingIcon = { Icon(icon, null, tint = TextMuted) },
            shape = RoundedCornerShape(14.dp),
            colors = darkFieldColors(),
            singleLine = true
        )
    }
}

@Composable
fun darkFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedTextColor = TextPrimary,
    unfocusedTextColor = TextPrimary,
    focusedBorderColor = AccentAmber,
    unfocusedBorderColor = BgElevated,
    focusedContainerColor = BgCard,
    unfocusedContainerColor = BgCard,
    cursorColor = AccentAmber
)

// ── Home Screen ───────────────────────────────────────────────────────────────

@Composable
fun HomeScreen(
    postList: List<SkillPost>,
    navController: NavController,
    strings: Strings,
    isDarkTheme: Boolean = true,
    onNewNotification: () -> Unit = {}
) {
    var searchText by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(strings.all) }

    val categories = listOf(strings.all, strings.plumbing, strings.electrical, strings.carpentry, strings.painting, strings.bikeRepair)

    LaunchedEffect(strings.all) {
        selectedCategory = strings.all
    }

    val filtered = postList.filter { post ->
        val matchSearch = searchText.isEmpty() ||
                post.name.contains(searchText, true) ||
                post.need.contains(searchText, true) ||
                post.offer.contains(searchText, true)
        val matchCat = selectedCategory == strings.all ||
                post.need.contains(selectedCategory, true) ||
                post.offer.contains(selectedCategory, true) ||
                post.category.contains(selectedCategory, true)
        matchSearch && matchCat
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .background(Brush.verticalGradient(listOf(MaterialTheme.colorScheme.surface, MaterialTheme.colorScheme.background)))
                .padding(start = 20.dp, end = 20.dp, top = 24.dp, bottom = 16.dp)
        ) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Column {
                    Text(strings.goodDay, color = TextSecondary, fontSize = 14.sp)
                    Text(strings.appName, fontSize = 30.sp, fontWeight = FontWeight.Black, color = MaterialTheme.colorScheme.onBackground, letterSpacing = (-0.5).sp)
                }
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(AccentAmber),
                    contentAlignment = Alignment.Center
                ) {
                    Text("R", fontWeight = FontWeight.Bold, color = BgDeep, fontSize = 18.sp)
                }
            }

            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(strings.searchPlaceholder, color = TextMuted) },
                leadingIcon = { Icon(Icons.Default.Search, null, tint = TextMuted) },
                trailingIcon = {
                    if (searchText.isNotEmpty()) {
                        IconButton(onClick = { searchText = "" }) {
                            Icon(Icons.Default.Close, null, tint = TextMuted, modifier = Modifier.size(18.dp))
                        }
                    }
                },
                shape = RoundedCornerShape(14.dp),
                colors = darkFieldColors(),
                singleLine = true
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            MiniStatCard(strings.activeSwaps, "128", AccentAmber, Modifier.weight(1f))
            MiniStatCard(strings.nearYou, "34", AccentTeal, Modifier.weight(1f))
            MiniStatCard(strings.yourPosts, "3", AccentRed, Modifier.weight(1f))
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) { cat ->
                val sel = cat == selectedCategory
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (sel) AccentAmber else MaterialTheme.colorScheme.surface)
                        .border(1.dp, if (sel) AccentAmber else BgElevated, RoundedCornerShape(12.dp))
                        .clickable { selectedCategory = cat }
                        .padding(horizontal = 16.dp, vertical = 9.dp)
                ) {
                    Text(cat, color = if (sel) BgDeep else TextSecondary, fontSize = 13.sp, fontWeight = if (sel) FontWeight.SemiBold else FontWeight.Normal)
                }
            }
        }

        Spacer(Modifier.height(12.dp))

        Text(
            "${filtered.size} ${strings.swapsAvailable}",
            color = TextMuted,
            fontSize = 13.sp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(Modifier.height(8.dp))

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(filtered) { post ->
                SkillPostCard(post, strings) {
                    onNewNotification()
                    navController.navigate("privateChat/${post.name}")
                }
            }
            if (filtered.isEmpty()) {
                item { EmptyState(strings.noSwapsFound, strings.tryDifferentSearch) }
            }
            item { Spacer(Modifier.height(8.dp)) }
        }
    }
}

@Composable
fun MiniStatCard(label: String, value: String, accent: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(MaterialTheme.colorScheme.surface)
            .border(1.dp, BgElevated, RoundedCornerShape(14.dp))
            .padding(12.dp)
    ) {
        Column {
            Text(value, fontSize = 22.sp, fontWeight = FontWeight.Black, color = accent)
            Spacer(Modifier.height(2.dp))
            Text(label, fontSize = 11.sp, color = TextMuted, maxLines = 2)
        }
    }
}

// ── Skill Post Card ───────────────────────────────────────────────────────────

@Composable
fun SkillPostCard(post: SkillPost, strings: Strings, onChatClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, BgElevated),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(
                            Brush.linearGradient(listOf(AccentAmber.copy(0.3f), AccentTeal.copy(0.3f)))
                        )
                        .border(2.dp, AccentAmber.copy(0.4f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(post.name.first().toString(), fontWeight = FontWeight.Bold, color = AccentAmber, fontSize = 20.sp)
                }
                Spacer(Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(post.name, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Star, null, tint = AccentAmber, modifier = Modifier.size(13.dp))
                        Spacer(Modifier.width(3.dp))
                        Text("${post.rating}", color = AccentAmber, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        Text("  ·  ${post.swaps} ${strings.swaps}", color = TextMuted, fontSize = 12.sp)
                    }
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(AccentTeal.copy(0.15f))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(post.category.ifEmpty { strings.general }, color = AccentTeal, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                }
            }

            Spacer(Modifier.height(14.dp))
            HorizontalDivider(color = Divider)
            Spacer(Modifier.height(14.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(AccentRed.copy(0.15f))
                        .padding(horizontal = 7.dp, vertical = 3.dp)
                ) {
                    Text(strings.needs, color = AccentRed, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.width(10.dp))
                Text(post.need, color = MaterialTheme.colorScheme.onSurface, fontSize = 14.sp)
            }

            Spacer(Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(OnlineGreen.copy(0.15f))
                        .padding(horizontal = 7.dp, vertical = 3.dp)
                ) {
                    Text(strings.offers, color = OnlineGreen, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.width(10.dp))
                Text(post.offer, color = MaterialTheme.colorScheme.onSurface, fontSize = 14.sp)
            }

            Spacer(Modifier.height(16.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                OutlinedButton(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.dp, BgElevated),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = TextSecondary)
                ) {
                    Icon(Icons.Default.BookmarkBorder, null, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(4.dp))
                    Text(strings.save, fontSize = 13.sp)
                }
                Button(
                    onClick = onChatClick,
                    modifier = Modifier.weight(2f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = AccentAmber)
                ) {
                    Icon(Icons.Default.ChatBubble, null, tint = BgDeep, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(6.dp))
                    Text(strings.startSwap, color = BgDeep, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
            }
        }
    }
}

// ── Explore Screen ────────────────────────────────────────────────────────────
// Changes:
//   • "Needs" and "Offers" are pinned toggle-chips (checklist-style) beside "All"
//   • The scrollable category row below supports multi-select (checklist)
//   • Both filter sets are ANDed together

@Composable
fun ExploreScreen(postList: List<SkillPost>, navController: NavController, strings: Strings) {
    val scrollableCategories = listOf(
        strings.plumbing, strings.electrical, strings.carpentry,
        strings.painting, strings.bikeRepair, strings.acService
    )

    // Multi-select category set; empty = All
    val selectedCategories = remember { mutableStateSetOf<String>() }

    // Pinned Needs / Offers toggles
    var filterNeeds  by remember { mutableStateOf(false) }
    var filterOffers by remember { mutableStateOf(false) }

    var searchText by remember { mutableStateOf("") }

    val filtered = postList.filter { post ->
        val matchSearch = searchText.isEmpty() ||
                post.name.contains(searchText, true) ||
                post.need.contains(searchText, true) ||
                post.offer.contains(searchText, true)

        // Category multi-select: empty set = show all
        val matchCat = selectedCategories.isEmpty() ||
                selectedCategories.any { cat ->
                    post.need.contains(cat, true) ||
                            post.offer.contains(cat, true) ||
                            post.category.contains(cat, true)
                }

        // Needs / Offers type filter
        val matchType = when {
            filterNeeds && filterOffers -> true   // both checked = show all
            filterNeeds  -> post.need.isNotEmpty()
            filterOffers -> post.offer.isNotEmpty()
            else         -> true
        }

        matchSearch && matchCat && matchType
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header + search
        Column(
            modifier = Modifier
                .background(Brush.verticalGradient(listOf(MaterialTheme.colorScheme.surface, MaterialTheme.colorScheme.background)))
                .padding(start = 20.dp, end = 20.dp, top = 24.dp, bottom = 16.dp)
        ) {
            Text(strings.explore, fontSize = 30.sp, fontWeight = FontWeight.Black, color = MaterialTheme.colorScheme.onBackground, letterSpacing = (-0.5).sp)
            Text(strings.exploreSubtitle, color = TextSecondary, fontSize = 14.sp)
            Spacer(Modifier.height(14.dp))
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(strings.searchBySkill, color = TextMuted) },
                leadingIcon = { Icon(Icons.Default.Search, null, tint = TextMuted) },
                trailingIcon = {
                    if (searchText.isNotEmpty()) {
                        IconButton(onClick = { searchText = "" }) {
                            Icon(Icons.Default.Close, null, tint = TextMuted, modifier = Modifier.size(18.dp))
                        }
                    }
                },
                shape = RoundedCornerShape(14.dp),
                colors = darkFieldColors(),
                singleLine = true
            )
        }

        // ── Pinned filter row: All · Needs · Offers ───────────────────────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // "All" resets everything
            val allSelected = selectedCategories.isEmpty() && !filterNeeds && !filterOffers
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(if (allSelected) AccentAmber else MaterialTheme.colorScheme.surface)
                    .border(1.dp, if (allSelected) AccentAmber else BgElevated, RoundedCornerShape(12.dp))
                    .clickable {
                        selectedCategories.clear()
                        filterNeeds = false
                        filterOffers = false
                    }
                    .padding(horizontal = 16.dp, vertical = 9.dp)
            ) {
                Text(
                    strings.all,
                    color = if (allSelected) BgDeep else TextSecondary,
                    fontSize = 13.sp,
                    fontWeight = if (allSelected) FontWeight.SemiBold else FontWeight.Normal
                )
            }

            // Needs toggle chip with checkbox feel
            PinnedFilterChip(
                label = strings.needsFilter,
                checked = filterNeeds,
                activeColor = AccentRed,
                onToggle = { filterNeeds = !filterNeeds }
            )

            // Offers toggle chip with checkbox feel
            PinnedFilterChip(
                label = strings.offersFilter,
                checked = filterOffers,
                activeColor = OnlineGreen,
                onToggle = { filterOffers = !filterOffers }
            )
        }

        // ── Scrollable multi-select category chips ────────────────────────────
        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(scrollableCategories) { cat ->
                val sel = selectedCategories.contains(cat)
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (sel) AccentAmber else MaterialTheme.colorScheme.surface)
                        .border(
                            width = if (sel) 0.dp else 1.dp,
                            color = if (sel) AccentAmber else BgElevated,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .clickable {
                            if (sel) selectedCategories.remove(cat) else selectedCategories.add(cat)
                        }
                        .padding(horizontal = 14.dp, vertical = 9.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        if (sel) {
                            Icon(
                                Icons.Default.Check,
                                contentDescription = null,
                                tint = BgDeep,
                                modifier = Modifier.size(13.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                        }
                        Text(
                            cat,
                            color = if (sel) BgDeep else TextSecondary,
                            fontSize = 13.sp,
                            fontWeight = if (sel) FontWeight.SemiBold else FontWeight.Normal
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(8.dp))
        Text(
            "${filtered.size} ${strings.results}",
            color = TextMuted,
            fontSize = 13.sp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(Modifier.height(8.dp))

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(filtered) { post ->
                SkillPostCard(post, strings) { navController.navigate("privateChat/${post.name}") }
            }
            if (filtered.isEmpty()) {
                item { EmptyState(strings.noResults, strings.tryAdjusting) }
            }
            item { Spacer(Modifier.height(8.dp)) }
        }
    }
}

/**
 * A pinned toggle chip that shows a small checkbox-style indicator when active.
 * Used for Needs / Offers in the Explore filter row.
 */
@Composable
fun PinnedFilterChip(
    label: String,
    checked: Boolean,
    activeColor: Color,
    onToggle: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(if (checked) activeColor.copy(alpha = 0.15f) else MaterialTheme.colorScheme.surface)
            .border(
                width = if (checked) 1.5.dp else 1.dp,
                color = if (checked) activeColor else BgElevated,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(onClick = onToggle)
            .padding(horizontal = 12.dp, vertical = 9.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Mini checkbox indicator
            Box(
                modifier = Modifier
                    .size(14.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(if (checked) activeColor else BgElevated)
                    .border(1.dp, if (checked) activeColor else TextMuted, RoundedCornerShape(4.dp)),
                contentAlignment = Alignment.Center
            ) {
                if (checked) {
                    Icon(
                        Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(9.dp)
                    )
                }
            }
            Spacer(Modifier.width(6.dp))
            Text(
                label,
                color = if (checked) activeColor else TextSecondary,
                fontSize = 13.sp,
                fontWeight = if (checked) FontWeight.SemiBold else FontWeight.Normal
            )
        }
    }
}

// ── Add Post Screen ───────────────────────────────────────────────────────────

@Composable
fun AddPostScreen(
    postList: MutableList<SkillPost>,
    strings: Strings,
    onNewNotification: () -> Unit = {}
) {
    var skillNeeded by remember { mutableStateOf("") }
    var skillOffered by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("") }
    var posted by remember { mutableStateOf(false) }

    val categories = listOf(strings.plumbing, strings.electrical, strings.carpentry, strings.painting, strings.bikeRepair, strings.acService, strings.other)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.verticalGradient(listOf(MaterialTheme.colorScheme.surface, MaterialTheme.colorScheme.background)))
                .padding(start = 20.dp, end = 20.dp, top = 24.dp, bottom = 24.dp)
        ) {
            Column {
                Text(strings.createSwap, fontSize = 30.sp, fontWeight = FontWeight.Black, color = MaterialTheme.colorScheme.onBackground, letterSpacing = (-0.5).sp)
                Text(strings.createSwapSubtitle, color = TextSecondary, fontSize = 14.sp)
            }
        }

        Column(modifier = Modifier.padding(20.dp)) {

            if (posted) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = OnlineGreen.copy(0.12f)),
                    border = BorderStroke(1.dp, OnlineGreen.copy(0.4f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.CheckCircle, null, tint = OnlineGreen, modifier = Modifier.size(20.dp))
                        Spacer(Modifier.width(10.dp))
                        Text(strings.postPublished, color = OnlineGreen, fontWeight = FontWeight.SemiBold)
                    }
                }
                Spacer(Modifier.height(20.dp))
            }

            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = BorderStroke(1.dp, BgElevated),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(20.dp)) {

                    FormLabel(strings.whatDoYouNeed, Icons.Default.HelpOutline, AccentRed)
                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(
                        value = skillNeeded,
                        onValueChange = { skillNeeded = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text(strings.needPlaceholder, color = TextMuted) },
                        shape = RoundedCornerShape(14.dp),
                        colors = darkFieldColors(),
                        singleLine = true
                    )

                    Spacer(Modifier.height(20.dp))

                    FormLabel(strings.whatDoYouOffer, Icons.Default.Handshake, OnlineGreen)
                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(
                        value = skillOffered,
                        onValueChange = { skillOffered = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text(strings.offerPlaceholder, color = TextMuted) },
                        shape = RoundedCornerShape(14.dp),
                        colors = darkFieldColors(),
                        singleLine = true
                    )

                    Spacer(Modifier.height(20.dp))

                    FormLabel(strings.category, Icons.Default.Category, AccentAmber)
                    Spacer(Modifier.height(10.dp))

                    val chunked = categories.chunked(3)
                    chunked.forEach { row ->
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                            row.forEach { cat ->
                                val sel = cat == selectedCategory
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(if (sel) AccentAmber else BgElevated)
                                        .clickable { selectedCategory = cat }
                                        .padding(vertical = 10.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(cat, color = if (sel) BgDeep else TextSecondary, fontSize = 12.sp, fontWeight = if (sel) FontWeight.Bold else FontWeight.Normal, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                }
                            }
                            repeat(3 - row.size) {
                                Box(modifier = Modifier.weight(1f))
                            }
                        }
                        Spacer(Modifier.height(8.dp))
                    }
                }
            }

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = {
                    if (skillNeeded.isNotEmpty() && skillOffered.isNotEmpty()) {
                        postList.add(
                            SkillPost(
                                name = "You",
                                need = "Needs $skillNeeded",
                                offer = "Offers $skillOffered",
                                category = selectedCategory.ifEmpty { strings.general },
                                rating = 5.0f,
                                swaps = 0
                            )
                        )
                        skillNeeded = ""
                        skillOffered = ""
                        selectedCategory = ""
                        posted = true
                        onNewNotification()
                    }
                },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (skillNeeded.isNotEmpty() && skillOffered.isNotEmpty()) AccentAmber else BgElevated
                ),
                enabled = skillNeeded.isNotEmpty() && skillOffered.isNotEmpty()
            ) {
                Icon(Icons.Default.Send, null, tint = if (skillNeeded.isNotEmpty() && skillOffered.isNotEmpty()) BgDeep else TextMuted, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(8.dp))
                Text(
                    strings.publishSwap,
                    color = if (skillNeeded.isNotEmpty() && skillOffered.isNotEmpty()) BgDeep else TextMuted,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun FormLabel(text: String, icon: ImageVector, tint: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, null, tint = tint, modifier = Modifier.size(18.dp))
        Spacer(Modifier.width(8.dp))
        Text(text, color = TextSecondary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
    }
}

// ── Chat Screen ───────────────────────────────────────────────────────────────

@Composable
fun ChatScreen(navController: NavController, strings: Strings) {
    val chatUsers = remember {
        listOf(
            ChatUser("Ramesh K.", "Can you repair my wiring?", "10:20 PM", true, 2),
            ChatUser("Suresh M.", "Are you available tomorrow?", "11:10 PM", true, 0),
            ChatUser("Anil P.",   "Please reply to my request.", "12:00 AM", false, 1),
            ChatUser("Kiran D.",  "Waiting for your response.", "09:00 AM", true, 0),
            ChatUser("Meena S.", "When can we meet?", "Yesterday", false, 0)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .background(Brush.verticalGradient(listOf(MaterialTheme.colorScheme.surface, MaterialTheme.colorScheme.background)))
                .padding(start = 20.dp, end = 20.dp, top = 24.dp, bottom = 16.dp)
        ) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Column {
                    Text(strings.messages, fontSize = 30.sp, fontWeight = FontWeight.Black, color = MaterialTheme.colorScheme.onBackground, letterSpacing = (-0.5).sp)
                    Text("${chatUsers.count { it.online }} ${strings.onlineNow}", color = AccentTeal, fontSize = 13.sp)
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Edit, null, tint = TextSecondary)
                }
            }
        }

        Text(strings.activeNow, color = TextMuted, fontSize = 12.sp, fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 20.dp, top = 4.dp, bottom = 8.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(chatUsers.filter { it.online }) { user ->
                OnlineAvatar(user)
            }
        }

        Spacer(Modifier.height(16.dp))

        Text(strings.recent, color = TextMuted, fontSize = 12.sp, fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 20.dp, bottom = 8.dp))

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(chatUsers) { user ->
                ChatListItem(user) { navController.navigate("privateChat/${user.name}") }
            }
        }
    }
}

@Composable
fun OnlineAvatar(user: ChatUser) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box {
            Box(
                modifier = Modifier
                    .size(58.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.linearGradient(listOf(AccentAmber.copy(0.25f), AccentTeal.copy(0.25f)))
                    )
                    .border(2.dp, AccentAmber.copy(0.5f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(user.name.first().toString(), fontWeight = FontWeight.Bold, color = AccentAmber, fontSize = 22.sp)
            }
            if (user.online) {
                Box(
                    modifier = Modifier
                        .size(14.dp)
                        .clip(CircleShape)
                        .background(OnlineGreen)
                        .border(2.dp, BgDeep, CircleShape)
                        .align(Alignment.BottomEnd)
                )
            }
        }
        Spacer(Modifier.height(4.dp))
        Text(user.name.split(" ").first(), color = TextSecondary, fontSize = 11.sp, maxLines = 1)
    }
}

@Composable
fun ChatListItem(user: ChatUser, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .clip(CircleShape)
                    .background(BgElevated)
                    .border(1.5.dp, if (user.online) OnlineGreen.copy(0.5f) else BgElevated, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(user.name.first().toString(), fontWeight = FontWeight.Bold, color = TextPrimary, fontSize = 20.sp)
            }
            if (user.online) {
                Box(
                    modifier = Modifier
                        .size(13.dp)
                        .clip(CircleShape)
                        .background(OnlineGreen)
                        .border(2.dp, BgDeep, CircleShape)
                        .align(Alignment.BottomEnd)
                )
            }
        }
        Spacer(Modifier.width(14.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(user.name, fontWeight = FontWeight.SemiBold, color = TextPrimary, fontSize = 15.sp)
            Spacer(Modifier.height(2.dp))
            Text(user.lastMessage, color = TextMuted, fontSize = 13.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(user.time, color = TextMuted, fontSize = 11.sp)
            if (user.unread > 0) {
                Spacer(Modifier.height(4.dp))
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(AccentAmber),
                    contentAlignment = Alignment.Center
                ) {
                    Text("${user.unread}", color = BgDeep, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

// ── Private Chat Screen ───────────────────────────────────────────────────────

@Composable
fun PrivateChatScreen(
    userName: String,
    navController: NavController,
    strings: Strings,
    onNewNotification: () -> Unit = {}
) {
    val messages = remember {
        mutableStateListOf(
            ChatMessage(userName, "Hello! Interested in swapping skills?", "10:15 AM"),
            ChatMessage("You", "Yes! What kind of help do you need?", "10:16 AM"),
            ChatMessage(userName, "I need help with electrical wiring. I can offer plumbing in return.", "10:17 AM")
        )
    }
    var currentMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgDeep)
    ) {
        Surface(color = BgCard, shadowElevation = 8.dp) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, null, tint = TextSecondary)
                }
                Spacer(Modifier.width(4.dp))
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(Brush.linearGradient(listOf(AccentAmber.copy(0.3f), AccentTeal.copy(0.3f)))),
                    contentAlignment = Alignment.Center
                ) {
                    Text(userName.first().toString(), fontWeight = FontWeight.Bold, color = AccentAmber, fontSize = 18.sp)
                }
                Spacer(Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(userName, fontWeight = FontWeight.Bold, color = TextPrimary, fontSize = 16.sp)
                    Text(strings.online, color = OnlineGreen, fontSize = 12.sp)
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Default.MoreVert, null, tint = TextSecondary)
                }
            }
        }

        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(messages) { msg -> ChatBubble(msg) }
        }

        Surface(color = BgCard, shadowElevation = 16.dp) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .imePadding(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = currentMessage,
                    onValueChange = { currentMessage = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text(strings.messagePlaceholder, color = TextMuted) },
                    shape = RoundedCornerShape(20.dp),
                    colors = darkFieldColors(),
                    singleLine = true
                )
                Spacer(Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(if (currentMessage.isNotEmpty()) AccentAmber else BgElevated)
                        .clickable {
                            if (currentMessage.isNotEmpty()) {
                                messages.add(ChatMessage("You", currentMessage, "Now"))
                                onNewNotification()
                                currentMessage = ""
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Send, null, tint = if (currentMessage.isNotEmpty()) BgDeep else TextMuted, modifier = Modifier.size(20.dp))
                }
            }
        }
    }
}

@Composable
fun ChatBubble(chat: ChatMessage) {
    val isUser = chat.sender == "You"
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start
    ) {
        Column(horizontalAlignment = if (isUser) Alignment.End else Alignment.Start) {
            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 18.dp, topEnd = 18.dp,
                            bottomStart = if (isUser) 18.dp else 4.dp,
                            bottomEnd = if (isUser) 4.dp else 18.dp
                        )
                    )
                    .background(if (isUser) AccentAmber else BgCard)
                    .border(if (isUser) 0.dp else 1.dp, BgElevated,
                        RoundedCornerShape(
                            topStart = 18.dp, topEnd = 18.dp,
                            bottomStart = if (isUser) 18.dp else 4.dp,
                            bottomEnd = if (isUser) 4.dp else 18.dp
                        ))
                    .padding(horizontal = 16.dp, vertical = 10.dp)
                    .widthIn(max = 280.dp)
            ) {
                Text(chat.message, color = if (isUser) BgDeep else TextPrimary, fontSize = 14.sp)
            }
            if (chat.time.isNotEmpty()) {
                Spacer(Modifier.height(3.dp))
                Text(chat.time, color = TextMuted, fontSize = 10.sp)
            }
        }
    }
}

// ── Profile Screen ────────────────────────────────────────────────────────────

@Composable
fun ProfileScreen(
    strings: Strings,
    currentLanguage: AppLanguage,
    onLanguageChange: (AppLanguage) -> Unit,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    userProfile: UserProfile,
    onProfileUpdate: (UserProfile) -> Unit,
    notificationVolume: Float,
    onVolumeChange: (Float) -> Unit,
    notificationCount: Int,
    onClearNotifications: () -> Unit,
    onSignOut: () -> Unit
) {
    var showLanguageDialog      by remember { mutableStateOf(false) }
    var showEditProfile         by remember { mutableStateOf(false) }
    var showNotifications       by remember { mutableStateOf(false) }
    var showSecurityPrivacy     by remember { mutableStateOf(false) }
    var showTheme               by remember { mutableStateOf(false) }
    var showContactUs           by remember { mutableStateOf(false) }
    var showPrivacyPolicy       by remember { mutableStateOf(false) }
    var showSignOutConfirm      by remember { mutableStateOf(false) }
    var showHelpCenter          by remember { mutableStateOf(false) }
    // NEW: avatar picker dialog
    var showAvatarPicker        by remember { mutableStateOf(false) }

    // ── Avatar / Photo Picker Dialog ──────────────────────────────────────────
    // Since Android camera/gallery requires ActivityResultContracts which cannot
    // be wired here without a ViewModel, we offer a rich emoji-avatar picker
    // as the profile photo selection mechanism. Swap in a real image launcher
    // when you wire up the Activity result callback.
    if (showAvatarPicker) {
        val avatarOptions = listOf(
            "😊", "😎", "🧑‍💻", "👷", "🧑‍🔧", "👩‍🎨",
            "🧑‍🍳", "👨‍🏫", "👩‍⚕️", "🧑‍🌾", "🦸", "🧙"
        )
        AlertDialog(
            onDismissRequest = { showAvatarPicker = false },
            containerColor = BgCard,
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.PhotoCamera, null, tint = AccentAmber, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(strings.chooseAvatar, color = TextPrimary, fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text(
                        "Pick an avatar for your profile",
                        color = TextSecondary,
                        fontSize = 13.sp
                    )

                    // Avatar grid
                    val rows = avatarOptions.chunked(4)
                    rows.forEach { row ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            row.forEach { emoji ->
                                val isSelected = userProfile.avatarEmoji == emoji
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .aspectRatio(1f)
                                        .clip(RoundedCornerShape(14.dp))
                                        .background(
                                            if (isSelected) AccentAmber.copy(0.2f) else BgElevated
                                        )
                                        .border(
                                            width = if (isSelected) 2.dp else 0.dp,
                                            color = if (isSelected) AccentAmber else Color.Transparent,
                                            shape = RoundedCornerShape(14.dp)
                                        )
                                        .clickable {
                                            onProfileUpdate(userProfile.copy(avatarEmoji = emoji))
                                            showAvatarPicker = false
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(emoji, fontSize = 28.sp)
                                }
                            }
                            // Fill remaining cells in last row
                            repeat(4 - row.size) {
                                Box(modifier = Modifier.weight(1f))
                            }
                        }
                    }

                    // Option to revert to initials
                    if (userProfile.avatarEmoji.isNotEmpty()) {
                        OutlinedButton(
                            onClick = {
                                onProfileUpdate(userProfile.copy(avatarEmoji = ""))
                                showAvatarPicker = false
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(1.dp, BgElevated),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = TextSecondary)
                        ) {
                            Icon(Icons.Default.Person, null, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("Use initials instead", fontSize = 13.sp)
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showAvatarPicker = false }) {
                    Text("Cancel", color = TextSecondary)
                }
            }
        )
    }

    // ── Language Dialog ───────────────────────────────────────────────────────
    if (showLanguageDialog) {
        AlertDialog(
            onDismissRequest = { showLanguageDialog = false },
            containerColor = BgCard,
            title = { Text(strings.language, color = TextPrimary, fontWeight = FontWeight.Bold) },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf(AppLanguage.ENGLISH to "English", AppLanguage.KANNADA to "ಕನ್ನಡ").forEach { (lang, label) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(if (currentLanguage == lang) AccentAmber.copy(0.15f) else BgElevated)
                                .clickable { onLanguageChange(lang); showLanguageDialog = false }
                                .padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(label, color = if (currentLanguage == lang) AccentAmber else TextPrimary, fontWeight = FontWeight.Medium)
                            if (currentLanguage == lang) Icon(Icons.Default.Check, null, tint = AccentAmber, modifier = Modifier.size(18.dp))
                        }
                    }
                }
            },
            confirmButton = {}
        )
    }

    // ── Edit Profile Dialog ───────────────────────────────────────────────────
    if (showEditProfile) {
        var editName     by remember { mutableStateOf(userProfile.name) }
        var editTitle    by remember { mutableStateOf(userProfile.title) }
        var editLocation by remember { mutableStateOf(userProfile.location) }
        var editPhone    by remember { mutableStateOf(userProfile.phone) }
        var editBio      by remember { mutableStateOf(userProfile.bio) }

        AlertDialog(
            onDismissRequest = { showEditProfile = false },
            containerColor = BgCard,
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Edit, null, tint = AccentAmber, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(strings.editProfile, color = TextPrimary, fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    ProfileEditField("Full Name", Icons.Default.Person, editName) { editName = it }
                    ProfileEditField("Title / Role", Icons.Default.Work, editTitle) { editTitle = it }
                    ProfileEditField("Location", Icons.Default.LocationOn, editLocation) { editLocation = it }
                    ProfileEditField("Phone", Icons.Default.Phone, editPhone) { editPhone = it }
                    ProfileEditField("Bio", Icons.Default.Info, editBio) { editBio = it }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onProfileUpdate(userProfile.copy(
                            name = editName,
                            title = editTitle,
                            location = editLocation,
                            phone = editPhone,
                            bio = editBio
                        ))
                        showEditProfile = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = AccentAmber),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(strings.save, color = BgDeep, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { showEditProfile = false }) {
                    Text("Cancel", color = TextSecondary)
                }
            }
        )
    }

    // ── Notifications Dialog ──────────────────────────────────────────────────
    if (showNotifications) {
        val isMuted = notificationVolume == 0f
        AlertDialog(
            onDismissRequest = { showNotifications = false },
            containerColor = BgCard,
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Notifications, null, tint = AccentTeal, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(strings.notifications, color = TextPrimary, fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    if (notificationCount > 0) {
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = AccentAmber.copy(0.12f)),
                            border = BorderStroke(1.dp, AccentAmber.copy(0.3f))
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Default.Notifications, null, tint = AccentAmber, modifier = Modifier.size(16.dp))
                                    Spacer(Modifier.width(8.dp))
                                    Text("$notificationCount new notifications", color = AccentAmber, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                                }
                                TextButton(onClick = { onClearNotifications() }) {
                                    Text("Clear", color = TextSecondary, fontSize = 12.sp)
                                }
                            }
                        }
                    }

                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    if (isMuted) Icons.Default.VolumeOff else Icons.Default.VolumeUp,
                                    null,
                                    tint = if (isMuted) AccentRed else AccentTeal,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(Modifier.width(10.dp))
                                Text("Notification Sound", color = TextPrimary, fontWeight = FontWeight.Medium, fontSize = 14.sp)
                            }
                            Text(
                                if (isMuted) "Muted" else "${(notificationVolume * 100).toInt()}%",
                                color = if (isMuted) AccentRed else AccentTeal,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        Spacer(Modifier.height(8.dp))
                        Slider(
                            value = notificationVolume,
                            onValueChange = { onVolumeChange(it) },
                            modifier = Modifier.fillMaxWidth(),
                            colors = SliderDefaults.colors(
                                thumbColor = if (isMuted) AccentRed else AccentAmber,
                                activeTrackColor = if (isMuted) AccentRed else AccentAmber,
                                inactiveTrackColor = BgElevated
                            )
                        )
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("Mute", color = TextMuted, fontSize = 11.sp)
                            Text("Max", color = TextMuted, fontSize = 11.sp)
                        }
                    }

                    OutlinedButton(
                        onClick = { if (isMuted) onVolumeChange(0.7f) else onVolumeChange(0f) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.dp, if (isMuted) OnlineGreen.copy(0.5f) else AccentRed.copy(0.5f)),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = if (isMuted) OnlineGreen else AccentRed)
                    ) {
                        Icon(if (isMuted) Icons.Default.VolumeUp else Icons.Default.VolumeOff, null, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(8.dp))
                        Text(if (isMuted) "Unmute Notifications" else "Mute Notifications", fontWeight = FontWeight.SemiBold)
                    }

                    NotifToggleRow("New Swap Requests", true, AccentAmber)
                    NotifToggleRow("Chat Messages", true, AccentTeal)
                    NotifToggleRow("Swap Completed", true, OnlineGreen)
                    NotifToggleRow("Promotional Alerts", false, TextMuted)
                }
            },
            confirmButton = {
                Button(
                    onClick = { showNotifications = false },
                    colors = ButtonDefaults.buttonColors(containerColor = AccentAmber),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Done", color = BgDeep, fontWeight = FontWeight.Bold)
                }
            }
        )
    }

    // ── Security & Privacy Dialog ─────────────────────────────────────────────
    if (showSecurityPrivacy) {
        var showDeleteConfirm by remember { mutableStateOf(false) }
        var showClearChatConfirm by remember { mutableStateOf(false) }
        var showClearDataConfirm by remember { mutableStateOf(false) }
        var actionDone by remember { mutableStateOf("") }

        if (showDeleteConfirm) {
            AlertDialog(
                onDismissRequest = { showDeleteConfirm = false },
                containerColor = BgCard,
                title = { Text("Delete Account?", color = AccentRed, fontWeight = FontWeight.Bold) },
                text = { Text("This action is permanent and cannot be undone. All your data, swaps, and messages will be deleted.", color = TextSecondary, fontSize = 14.sp) },
                confirmButton = {
                    Button(
                        onClick = { showDeleteConfirm = false; showSecurityPrivacy = false; onSignOut() },
                        colors = ButtonDefaults.buttonColors(containerColor = AccentRed),
                        shape = RoundedCornerShape(12.dp)
                    ) { Text("Delete Forever", color = Color.White, fontWeight = FontWeight.Bold) }
                },
                dismissButton = {
                    TextButton(onClick = { showDeleteConfirm = false }) { Text("Cancel", color = TextSecondary) }
                }
            )
        }

        if (showClearChatConfirm) {
            AlertDialog(
                onDismissRequest = { showClearChatConfirm = false },
                containerColor = BgCard,
                title = { Text("Clear All Chats?", color = AccentAmber, fontWeight = FontWeight.Bold) },
                text = { Text("All your chat history will be permanently cleared. This cannot be undone.", color = TextSecondary, fontSize = 14.sp) },
                confirmButton = {
                    Button(
                        onClick = { showClearChatConfirm = false; actionDone = "Chat history cleared." },
                        colors = ButtonDefaults.buttonColors(containerColor = AccentAmber),
                        shape = RoundedCornerShape(12.dp)
                    ) { Text("Clear Chats", color = BgDeep, fontWeight = FontWeight.Bold) }
                },
                dismissButton = {
                    TextButton(onClick = { showClearChatConfirm = false }) { Text("Cancel", color = TextSecondary) }
                }
            )
        }

        if (showClearDataConfirm) {
            AlertDialog(
                onDismissRequest = { showClearDataConfirm = false },
                containerColor = BgCard,
                title = { Text("Clear App Data?", color = AccentAmber, fontWeight = FontWeight.Bold) },
                text = { Text("This will reset all app preferences and cached data. Your account will remain active.", color = TextSecondary, fontSize = 14.sp) },
                confirmButton = {
                    Button(
                        onClick = { showClearDataConfirm = false; actionDone = "App data cleared." },
                        colors = ButtonDefaults.buttonColors(containerColor = AccentAmber),
                        shape = RoundedCornerShape(12.dp)
                    ) { Text("Clear Data", color = BgDeep, fontWeight = FontWeight.Bold) }
                },
                dismissButton = {
                    TextButton(onClick = { showClearDataConfirm = false }) { Text("Cancel", color = TextSecondary) }
                }
            )
        }

        AlertDialog(
            onDismissRequest = { showSecurityPrivacy = false },
            containerColor = BgCard,
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Security, null, tint = AccentAmber, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(strings.securityPrivacy, color = TextPrimary, fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    if (actionDone.isNotEmpty()) {
                        Card(
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(containerColor = OnlineGreen.copy(0.12f)),
                            border = BorderStroke(1.dp, OnlineGreen.copy(0.3f))
                        ) {
                            Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.CheckCircle, null, tint = OnlineGreen, modifier = Modifier.size(16.dp))
                                Spacer(Modifier.width(8.dp))
                                Text(actionDone, color = OnlineGreen, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                            }
                        }
                    }

                    Text("Data Management", color = TextMuted, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, letterSpacing = 0.5.sp)

                    SecurityActionRow(
                        icon = Icons.Default.DeleteSweep,
                        label = "Clear App Data",
                        subtitle = "Reset preferences & cache",
                        tint = AccentAmber
                    ) { showClearDataConfirm = true }

                    SecurityActionRow(
                        icon = Icons.Default.Chat,
                        label = "Clear Chat History",
                        subtitle = "Delete all conversations",
                        tint = AccentTeal
                    ) { showClearChatConfirm = true }

                    HorizontalDivider(color = Divider)

                    Text("Account", color = TextMuted, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, letterSpacing = 0.5.sp)

                    SecurityActionRow(
                        icon = Icons.Default.Lock,
                        label = "Change Password",
                        subtitle = "Update your password",
                        tint = AccentAmber
                    ) { actionDone = "Password reset email sent." }

                    SecurityActionRow(
                        icon = Icons.Default.PhoneAndroid,
                        label = "Two-Factor Auth",
                        subtitle = "Add extra security",
                        tint = AccentTeal
                    ) { actionDone = "2FA setup link sent to your email." }

                    HorizontalDivider(color = Divider)

                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = AccentRed.copy(0.08f)),
                        border = BorderStroke(1.dp, AccentRed.copy(0.3f)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { showDeleteConfirm = true }
                    ) {
                        Row(
                            modifier = Modifier.padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(AccentRed.copy(0.15f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.DeleteForever, null, tint = AccentRed, modifier = Modifier.size(20.dp))
                            }
                            Spacer(Modifier.width(12.dp))
                            Column(Modifier.weight(1f)) {
                                Text("Delete Account", color = AccentRed, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                                Text("Permanently remove your account", color = AccentRed.copy(0.7f), fontSize = 12.sp)
                            }
                            Icon(Icons.Default.KeyboardArrowRight, null, tint = AccentRed.copy(0.6f), modifier = Modifier.size(20.dp))
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showSecurityPrivacy = false }) {
                    Text("Close", color = TextSecondary)
                }
            }
        )
    }

    // ── Theme Dialog ──────────────────────────────────────────────────────────
    if (showTheme) {
        AlertDialog(
            onDismissRequest = { showTheme = false },
            containerColor = BgCard,
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.DarkMode, null, tint = AccentAmber, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(strings.theme, color = TextPrimary, fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text("Choose your preferred appearance", color = TextSecondary, fontSize = 13.sp)
                    Spacer(Modifier.height(4.dp))
                    ThemeOption(
                        icon = Icons.Default.DarkMode,
                        label = "Dark Theme",
                        subtitle = "Easy on the eyes at night",
                        selected = isDarkTheme,
                        accentColor = AccentAmber
                    ) { onThemeChange(true) }
                    ThemeOption(
                        icon = Icons.Default.LightMode,
                        label = "Light Theme",
                        subtitle = "Bright and clean look",
                        selected = !isDarkTheme,
                        accentColor = AccentTeal
                    ) { onThemeChange(false) }
                }
            },
            confirmButton = {
                Button(
                    onClick = { showTheme = false },
                    colors = ButtonDefaults.buttonColors(containerColor = AccentAmber),
                    shape = RoundedCornerShape(12.dp)
                ) { Text("Apply", color = BgDeep, fontWeight = FontWeight.Bold) }
            }
        )
    }

    // ── Contact Us (Chatbot) Dialog ───────────────────────────────────────────
    if (showContactUs) {
        ContactUsChatDialog(onDismiss = { showContactUs = false })
    }

    // ── Privacy Policy Dialog ─────────────────────────────────────────────────
    if (showPrivacyPolicy) {
        PrivacyPolicyDialog(onDismiss = { showPrivacyPolicy = false })
    }

    // ── Help Center Dialog ─────────────────────────────────────────────────────
    if (showHelpCenter) {
        AlertDialog(
            onDismissRequest = { showHelpCenter = false },
            containerColor = BgCard,
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.HelpOutline, null, tint = AccentAmber, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(strings.helpCenter, color = TextPrimary, fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    val faqs = listOf(
                        "How do I start a skill swap?" to "Browse listings or post your need, then tap 'Start Swap' on any matching post to begin chatting.",
                        "How are skill points earned?" to "You earn 10 points per completed swap. Points unlock premium features and boost your visibility.",
                        "Is SkillBarter free?" to "Yes! SkillBarter is completely free. We never charge for skill exchanges.",
                        "How do I verify my profile?" to "Submit your Aadhaar or government ID in Settings → Security & Privacy. Verification takes 24–48 hours.",
                        "Can I cancel a swap?" to "Yes, you can cancel before the swap is confirmed. Cancelling after confirmation may affect your rating."
                    )
                    faqs.forEach { (q, a) ->
                        var expanded by remember { mutableStateOf(false) }
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = BgElevated),
                            modifier = Modifier.fillMaxWidth().clickable { expanded = !expanded }
                        ) {
                            Column(Modifier.padding(12.dp)) {
                                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                                    Text(q, color = TextPrimary, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
                                    Icon(if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore, null, tint = TextMuted, modifier = Modifier.size(18.dp))
                                }
                                if (expanded) {
                                    Spacer(Modifier.height(8.dp))
                                    Text(a, color = TextSecondary, fontSize = 12.sp, lineHeight = 18.sp)
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showHelpCenter = false }) { Text("Close", color = TextSecondary) }
            }
        )
    }

    // ── Sign Out Confirmation ─────────────────────────────────────────────────
    if (showSignOutConfirm) {
        AlertDialog(
            onDismissRequest = { showSignOutConfirm = false },
            containerColor = BgCard,
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.ExitToApp, null, tint = AccentRed, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(strings.signOut, color = TextPrimary, fontWeight = FontWeight.Bold)
                }
            },
            text = { Text("Are you sure you want to sign out of SkillBarter?", color = TextSecondary, fontSize = 14.sp) },
            confirmButton = {
                Button(
                    onClick = { showSignOutConfirm = false; onSignOut() },
                    colors = ButtonDefaults.buttonColors(containerColor = AccentRed),
                    shape = RoundedCornerShape(12.dp)
                ) { Text(strings.signOut, color = Color.White, fontWeight = FontWeight.Bold) }
            },
            dismissButton = {
                TextButton(onClick = { showSignOutConfirm = false }) { Text("Stay", color = TextSecondary) }
            }
        )
    }

    // ── Main Profile Content ──────────────────────────────────────────────────
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.verticalGradient(listOf(AccentAmber.copy(0.12f), MaterialTheme.colorScheme.background)))
                .padding(20.dp)
        ) {
            Column {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(strings.profile, fontSize = 30.sp, fontWeight = FontWeight.Black, color = MaterialTheme.colorScheme.onBackground, letterSpacing = (-0.5).sp)
                    Box {
                        IconButton(onClick = { showNotifications = true }) {
                            Icon(Icons.Default.Notifications, null, tint = TextSecondary)
                        }
                        if (notificationCount > 0) {
                            Box(
                                modifier = Modifier
                                    .size(16.dp)
                                    .clip(CircleShape)
                                    .background(AccentRed)
                                    .align(Alignment.TopEnd)
                                    .offset(x = (-4).dp, y = 4.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    if (notificationCount > 9) "9+" else "$notificationCount",
                                    color = Color.White,
                                    fontSize = 8.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }

                Spacer(Modifier.height(20.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    // ── Profile photo avatar (tappable to open picker) ────────
                    Box {
                        Box(
                            modifier = Modifier
                                .size(84.dp)
                                .clip(CircleShape)
                                .background(Brush.linearGradient(listOf(AccentAmber.copy(0.4f), AccentTeal.copy(0.4f))))
                                .border(3.dp, AccentAmber, CircleShape)
                                .clickable { showAvatarPicker = true },
                            contentAlignment = Alignment.Center
                        ) {
                            if (userProfile.avatarEmoji.isNotEmpty()) {
                                // Show selected emoji avatar
                                Text(userProfile.avatarEmoji, fontSize = 40.sp)
                            } else {
                                // Fallback: initials
                                Text(
                                    userProfile.name.first().toString(),
                                    fontWeight = FontWeight.Black,
                                    color = AccentAmber,
                                    fontSize = 36.sp
                                )
                            }
                        }
                        // Camera badge — tapping opens the avatar picker
                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .clip(CircleShape)
                                .background(AccentAmber)
                                .align(Alignment.BottomEnd)
                                .clickable { showAvatarPicker = true },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.PhotoCamera, null, tint = BgDeep, modifier = Modifier.size(14.dp))
                        }
                    }
                    Spacer(Modifier.width(16.dp))
                    Column {
                        Text(userProfile.name, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                        Text(userProfile.title, color = TextSecondary, fontSize = 14.sp)
                        Spacer(Modifier.height(4.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(OnlineGreen.copy(0.15f))
                                    .padding(horizontal = 8.dp, vertical = 3.dp)
                            ) {
                                Text(strings.verified, color = OnlineGreen, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                            }
                            Spacer(Modifier.width(8.dp))
                            Icon(Icons.Default.LocationOn, null, tint = TextMuted, modifier = Modifier.size(13.dp))
                            Text(userProfile.location, color = TextMuted, fontSize = 12.sp)
                        }
                        Spacer(Modifier.height(4.dp))
                        // Tap to change photo hint
                        Text(
                            strings.changePhoto,
                            color = AccentAmber,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.clickable { showAvatarPicker = true }
                        )
                    }
                }
            }
        }

        Column(modifier = Modifier.padding(20.dp)) {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = BorderStroke(1.dp, BgElevated)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ProfileStat(strings.skillPoints, "245", AccentAmber)
                    VerticalDivider(Modifier.height(40.dp), color = BgElevated)
                    ProfileStat(strings.swapsDone, "18", AccentTeal)
                    VerticalDivider(Modifier.height(40.dp), color = BgElevated)
                    ProfileStat(strings.rating, "4.9 ★", OnlineGreen)
                }
            }

            Spacer(Modifier.height(20.dp))

            Text(strings.mySkills, color = TextSecondary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf("Android Dev", "UI Design", "React Native").forEach { skill ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(AccentAmber.copy(0.12f))
                            .border(1.dp, AccentAmber.copy(0.3f), RoundedCornerShape(10.dp))
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(skill, color = AccentAmber, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
            }

            Spacer(Modifier.height(24.dp))

            MenuSection(strings.account, listOf(
                Triple(strings.editProfile,      Icons.Default.Person,        AccentAmber),
                Triple(strings.notifications,    Icons.Default.Notifications, AccentTeal),
                Triple(strings.language,         Icons.Default.Language,      AccentRed)
            ), onItemClick = { label ->
                when (label) {
                    strings.editProfile   -> showEditProfile = true
                    strings.notifications -> showNotifications = true
                    strings.language      -> showLanguageDialog = true
                }
            })

            Spacer(Modifier.height(16.dp))

            MenuSection(strings.preferences, listOf(
                Triple(strings.securityPrivacy, Icons.Default.Security, AccentAmber),
                Triple(strings.theme,           Icons.Default.DarkMode,  AccentTeal)
            ), onItemClick = { label ->
                when (label) {
                    strings.securityPrivacy -> showSecurityPrivacy = true
                    strings.theme           -> showTheme = true
                }
            })

            Spacer(Modifier.height(16.dp))

            MenuSection(strings.support, listOf(
                Triple(strings.helpCenter,    Icons.Default.HelpOutline, AccentAmber),
                Triple(strings.contactUs,     Icons.Default.Call,         AccentTeal),
                Triple(strings.privacyPolicy, Icons.Default.Shield,       AccentRed)
            ), onItemClick = { label ->
                when (label) {
                    strings.helpCenter    -> showHelpCenter = true
                    strings.contactUs     -> showContactUs = true
                    strings.privacyPolicy -> showPrivacyPolicy = true
                }
            })

            Spacer(Modifier.height(20.dp))

            Text(strings.communityReviews, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
            Spacer(Modifier.height(12.dp))

            listOf(
                Triple("Ramesh K.", "5.0", "Very helpful and completed the repair quickly. Highly recommend!"),
                Triple("Suresh M.", "4.8", "Great communication and trustworthy skill exchange."),
                Triple("Anil P.",   "5.0", "Outstanding electrical work. Would swap again.")
            ).forEach { (name, rating, review) ->
                ReviewCard(name, rating, review, strings)
                Spacer(Modifier.height(10.dp))
            }

            Spacer(Modifier.height(16.dp))

            OutlinedButton(
                onClick = { showSignOutConfirm = true },
                modifier = Modifier.fillMaxWidth().height(52.dp),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, AccentRed.copy(0.5f)),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = AccentRed)
            ) {
                Icon(Icons.Default.ExitToApp, null, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(8.dp))
                Text(strings.signOut, fontWeight = FontWeight.SemiBold)
            }

            Spacer(Modifier.height(20.dp))
        }
    }
}

// ── Profile Helper Composables ────────────────────────────────────────────────

@Composable
fun ProfileEditField(label: String, icon: ImageVector, value: String, onValueChange: (String) -> Unit) {
    Column {
        Text(label, color = TextSecondary, fontSize = 12.sp, fontWeight = FontWeight.Medium)
        Spacer(Modifier.height(4.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(icon, null, tint = TextMuted, modifier = Modifier.size(18.dp)) },
            shape = RoundedCornerShape(12.dp),
            colors = darkFieldColors(),
            singleLine = true
        )
    }
}

@Composable
fun NotifToggleRow(label: String, default: Boolean, accent: Color) {
    var enabled by remember { mutableStateOf(default) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, color = TextPrimary, fontSize = 14.sp)
        Switch(
            checked = enabled,
            onCheckedChange = { enabled = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = BgDeep,
                checkedTrackColor = accent,
                uncheckedThumbColor = TextMuted,
                uncheckedTrackColor = BgElevated
            )
        )
    }
}

@Composable
fun SecurityActionRow(icon: ImageVector, label: String, subtitle: String, tint: Color, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(BgElevated)
            .clickable(onClick = onClick)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(tint.copy(0.15f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, null, tint = tint, modifier = Modifier.size(18.dp))
        }
        Spacer(Modifier.width(12.dp))
        Column(Modifier.weight(1f)) {
            Text(label, color = TextPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Text(subtitle, color = TextMuted, fontSize = 12.sp)
        }
        Icon(Icons.Default.KeyboardArrowRight, null, tint = TextMuted, modifier = Modifier.size(18.dp))
    }
}

@Composable
fun ThemeOption(icon: ImageVector, label: String, subtitle: String, selected: Boolean, accentColor: Color, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) accentColor.copy(0.12f) else BgElevated
        ),
        border = BorderStroke(if (selected) 2.dp else 1.dp, if (selected) accentColor else BgElevated),
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, null, tint = if (selected) accentColor else TextMuted, modifier = Modifier.size(24.dp))
            Spacer(Modifier.width(14.dp))
            Column(Modifier.weight(1f)) {
                Text(label, color = if (selected) accentColor else TextPrimary, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
                Text(subtitle, color = TextMuted, fontSize = 12.sp)
            }
            if (selected) {
                Icon(Icons.Default.CheckCircle, null, tint = accentColor, modifier = Modifier.size(20.dp))
            }
        }
    }
}

// ── Contact Us Chatbot Dialog ─────────────────────────────────────────────────

@Composable
fun ContactUsChatDialog(onDismiss: () -> Unit) {
    data class BotMessage(val text: String, val isUser: Boolean)

    val botResponses = mapOf(
        "refund"      to "We don't handle money — SkillBarter is a free platform. For swap disputes, visit Help Center.",
        "swap"        to "To start a swap, find a listing and tap 'Start Swap'. Both parties must agree before it begins.",
        "account"     to "For account issues, go to Profile → Security & Privacy, or email us at support@skillbarter.in",
        "bug"         to "Please describe the bug in detail. Our team will investigate within 24 hours. Thank you!",
        "delete"      to "To delete your account, go to Profile → Security & Privacy → Delete Account.",
        "rating"      to "Ratings are given after a completed swap. Both parties rate each other out of 5 stars.",
        "cancel"      to "You can cancel a swap before it's confirmed by the other party without affecting your rating.",
        "payment"     to "SkillBarter is completely free — no payments, no subscriptions. Skills are exchanged directly.",
        "verify"      to "To get verified, submit a government ID in Profile → Security & Privacy. It takes 24–48 hours.",
        "hello"       to "Hello! 👋 I'm the SkillBarter support bot. How can I help you today?",
        "hi"          to "Hi there! 👋 What can I help you with today?",
        "help"        to "Sure! You can ask me about swaps, account issues, ratings, verification, or anything else.",
        "default"     to "I'm not sure I understand. Could you rephrase? You can ask about swaps, account, ratings, or contact support@skillbarter.in"
    )

    val quickReplies = listOf("How to start a swap?", "Account issues", "Report a bug", "How ratings work?")

    val messages = remember {
        mutableStateListOf(
            BotMessage("Hello! 👋 Welcome to SkillBarter Support. I'm your virtual assistant. How can I help you today?", false),
            BotMessage("You can ask me about swaps, account issues, ratings, verification, and more.", false)
        )
    }
    var input by remember { mutableStateOf("") }

    fun respond(userText: String) {
        messages.add(BotMessage(userText, true))
        val lower = userText.lowercase()
        val reply = botResponses.entries.firstOrNull { lower.contains(it.key) }?.value
            ?: botResponses["default"]!!
        messages.add(BotMessage(reply, false))
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = BgCard,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Brush.linearGradient(listOf(AccentAmber, AccentTeal))),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.SmartToy, null, tint = BgDeep, modifier = Modifier.size(20.dp))
                }
                Spacer(Modifier.width(10.dp))
                Column {
                    Text("SkillBarter Support", color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text("Bot · Always online", color = OnlineGreen, fontSize = 11.sp)
                }
            }
        },
        text = {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp)
                ) {
                    val scrollState = rememberScrollState()
                    LaunchedEffect(messages.size) { scrollState.animateScrollTo(scrollState.maxValue) }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        messages.forEach { msg ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = if (msg.isUser) Arrangement.End else Arrangement.Start
                            ) {
                                if (!msg.isUser) {
                                    Box(
                                        modifier = Modifier
                                            .size(28.dp)
                                            .clip(CircleShape)
                                            .background(Brush.linearGradient(listOf(AccentAmber, AccentTeal))),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(Icons.Default.SmartToy, null, tint = BgDeep, modifier = Modifier.size(14.dp))
                                    }
                                    Spacer(Modifier.width(6.dp))
                                }
                                Box(
                                    modifier = Modifier
                                        .widthIn(max = 240.dp)
                                        .clip(
                                            RoundedCornerShape(
                                                topStart = 14.dp, topEnd = 14.dp,
                                                bottomStart = if (msg.isUser) 14.dp else 4.dp,
                                                bottomEnd = if (msg.isUser) 4.dp else 14.dp
                                            )
                                        )
                                        .background(if (msg.isUser) AccentAmber else BgElevated)
                                        .padding(horizontal = 12.dp, vertical = 8.dp)
                                ) {
                                    Text(
                                        msg.text,
                                        color = if (msg.isUser) BgDeep else TextPrimary,
                                        fontSize = 13.sp,
                                        lineHeight = 18.sp
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.height(4.dp))
                    }
                }

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(quickReplies) { qr ->
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(AccentAmber.copy(0.12f))
                                .border(1.dp, AccentAmber.copy(0.3f), RoundedCornerShape(20.dp))
                                .clickable { respond(qr) }
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Text(qr, color = AccentAmber, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = input,
                        onValueChange = { input = it },
                        modifier = Modifier.weight(1f),
                        placeholder = { Text("Type your message...", color = TextMuted, fontSize = 13.sp) },
                        shape = RoundedCornerShape(16.dp),
                        colors = darkFieldColors(),
                        singleLine = true
                    )
                    Spacer(Modifier.width(8.dp))
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(if (input.isNotEmpty()) AccentAmber else BgElevated)
                            .clickable {
                                if (input.isNotEmpty()) { respond(input); input = "" }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Send, null, tint = if (input.isNotEmpty()) BgDeep else TextMuted, modifier = Modifier.size(18.dp))
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("Close", color = TextSecondary) }
        }
    )
}

// ── Privacy Policy Dialog ─────────────────────────────────────────────────────

@Composable
fun PrivacyPolicyDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = BgCard,
        title = {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Shield, null, tint = AccentAmber, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("Privacy Policy", color = TextPrimary, fontWeight = FontWeight.Bold)
                }
                Text("SkillBarter Technologies Pvt. Ltd.", color = TextMuted, fontSize = 11.sp)
                Text("Effective: January 1, 2025 · Version 3.2", color = TextMuted, fontSize = 11.sp)
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .height(380.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                PrivacySection("1. Introduction", "SkillBarter Technologies Pvt. Ltd. (\"SkillBarter\", \"we\", \"us\", or \"our\") operates the SkillBarter mobile application and related services (collectively, the \"Service\"). This Privacy Policy explains how we collect, use, disclose, and protect your personal information when you use our Service. By using SkillBarter, you agree to the terms of this Privacy Policy.")
                PrivacySection("2. Information We Collect", "We collect information you provide directly: full name, email address, phone number, location (city/district), profile photo, skills offered and needed, and identity verification documents.\n\nWe also collect information automatically: device identifiers, IP address, app usage analytics, crash reports, and interaction data (swaps initiated, messages sent).\n\nWe do not collect financial information. SkillBarter is a free platform and no payments are processed through our Service.")
                PrivacySection("3. How We Use Your Information", "We use your information to:\n• Provide, maintain, and improve the Service\n• Facilitate skill swap connections between users\n• Verify your identity for the Verified badge\n• Send you notifications about swap requests and messages\n• Personalise your experience and recommend relevant swaps\n• Respond to support enquiries\n• Comply with applicable laws and regulations\n• Detect and prevent fraudulent or harmful activity")
                PrivacySection("4. Information Sharing", "We share your profile information (name, title, location, skills, rating) with other SkillBarter users as part of the platform's core functionality. We do not sell your personal data to third parties.\n\nWe may share data with trusted service providers who assist us in operating the Service (cloud hosting, analytics, customer support), subject to strict confidentiality agreements.\n\nWe may disclose information when required by law, court order, or governmental authority.")
                PrivacySection("5. Data Retention", "We retain your personal information for as long as your account is active or as needed to provide you Services. You may delete your account at any time via Profile → Security & Privacy → Delete Account. Upon deletion, your data is permanently removed within 30 days, except where retention is required by law.")
                PrivacySection("6. Security", "We implement industry-standard security measures including TLS 1.3 encryption for data in transit, AES-256 encryption for data at rest, two-factor authentication (optional), and regular security audits. However, no system is completely secure and we cannot guarantee absolute security.")
                PrivacySection("7. Your Rights", "Under applicable law, you have the right to:\n• Access the personal data we hold about you\n• Correct inaccurate data\n• Request deletion of your data\n• Object to processing of your data\n• Data portability\n\nTo exercise these rights, contact us at privacy@skillbarter.in or visit Profile → Security & Privacy.")
                PrivacySection("8. Children's Privacy", "SkillBarter is not directed at children under 18 years of age. We do not knowingly collect personal information from minors. If you believe we have inadvertently collected such information, please contact us immediately at legal@skillbarter.in.")
                PrivacySection("9. Changes to This Policy", "We may update this Privacy Policy from time to time. We will notify you of significant changes via in-app notification or email at least 14 days before they take effect. Continued use of the Service after changes constitutes acceptance.")
                PrivacySection("10. Contact Us", "SkillBarter Technologies Pvt. Ltd.\n4th Floor, Prestige Tech Park\nOuter Ring Road, Bengaluru – 560103\nKarnataka, India\n\nEmail: privacy@skillbarter.in\nGrievance Officer: Anand Raju\nPhone: +91 80 4567 8900\nResponse time: 48 hours")

                Card(
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = AccentAmber.copy(0.08f)),
                    border = BorderStroke(1.dp, AccentAmber.copy(0.2f))
                ) {
                    Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Verified, null, tint = AccentAmber, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(8.dp))
                        Text(
                            "This document complies with the Information Technology Act, 2000 and the Digital Personal Data Protection Act, 2023 (DPDPA).",
                            color = AccentAmber,
                            fontSize = 11.sp,
                            lineHeight = 16.sp
                        )
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = AccentAmber),
                shape = RoundedCornerShape(12.dp)
            ) { Text("I Understand", color = BgDeep, fontWeight = FontWeight.Bold) }
        }
    )
}

@Composable
fun PrivacySection(title: String, body: String) {
    Column {
        Text(title, color = AccentAmber, fontSize = 13.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(4.dp))
        Text(body, color = TextSecondary, fontSize = 12.sp, lineHeight = 18.sp)
    }
}

// ── Shared Profile Composables ─────────────────────────────────────────────────

@Composable
fun ProfileStat(label: String, value: String, accent: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, fontSize = 20.sp, fontWeight = FontWeight.Black, color = accent)
        Spacer(Modifier.height(2.dp))
        Text(label, fontSize = 12.sp, color = TextMuted, maxLines = 2)
    }
}

@Composable
fun MenuSection(
    title: String,
    items: List<Triple<String, ImageVector, Color>>,
    onItemClick: ((String) -> Unit)? = null
) {
    Text(title, color = TextMuted, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, letterSpacing = 0.5.sp)
    Spacer(Modifier.height(8.dp))
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, BgElevated),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            items.forEachIndexed { i, (label, icon, tint) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClick?.invoke(label) }
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(tint.copy(0.12f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(icon, null, tint = tint, modifier = Modifier.size(18.dp))
                    }
                    Spacer(Modifier.width(14.dp))
                    Text(label, color = MaterialTheme.colorScheme.onSurface, fontSize = 15.sp, modifier = Modifier.weight(1f))
                    Icon(Icons.Default.KeyboardArrowRight, null, tint = TextMuted, modifier = Modifier.size(20.dp))
                }
                if (i < items.lastIndex) HorizontalDivider(color = Divider, modifier = Modifier.padding(horizontal = 16.dp))
            }
        }
    }
}

@Composable
fun ReviewCard(name: String, rating: String, review: String, strings: Strings) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, BgElevated),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(BgElevated),
                    contentAlignment = Alignment.Center
                ) {
                    Text(name.first().toString(), fontWeight = FontWeight.Bold, color = TextPrimary)
                }
                Spacer(Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(name, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.onSurface, fontSize = 14.sp)
                    Text(strings.skillBarterMember, color = TextMuted, fontSize = 11.sp)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Star, null, tint = AccentAmber, modifier = Modifier.size(14.dp))
                    Spacer(Modifier.width(3.dp))
                    Text(rating, color = AccentAmber, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
            Spacer(Modifier.height(10.dp))
            Text(review, color = TextSecondary, fontSize = 13.sp, lineHeight = 20.sp)
        }
    }
}

// ── Empty State ───────────────────────────────────────────────────────────────

@Composable
fun EmptyState(title: String, subtitle: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(48.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surface),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.SearchOff, null, tint = TextMuted, modifier = Modifier.size(36.dp))
            }
            Spacer(Modifier.height(16.dp))
            Text(title, color = MaterialTheme.colorScheme.onBackground, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(4.dp))
            Text(subtitle, color = TextMuted, fontSize = 13.sp)
        }
    }
}