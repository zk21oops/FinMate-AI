# 💸 FinMate AI — AI-Powered Expense Tracker Android App

![feature_graphic_high_res](https://github.com/user-attachments/assets/e9f8e82f-5e8f-4963-8eb8-720695b95f6b)


Ever wished your wallet could talk? Well, now it can! 🗣️ This isn't just another expense tracker – it's your personal financial companion powered by artificial intelligence. Built with modern Android tech and a sprinkle of AI magic ✨, it turns those boring bank SMSs into meaningful insights about your spending habits.

> [!IMPORTANT]
> Currently, SMS analysis is only supported for the following Qatar banks:
> - QNB (Qatar National Bank)
> - QIB (Qatar Islamic Bank)
> - CBQ (Commercial Bank of Qatar)
> - Doha Bank
>
> Want to add support for your bank? Please create an issue with:
> - Bank name as it appears in SMS inbox
> - A sample SMS from a card purchase (please remove sensitive information)

## ✨ What Makes It Special?

- 🤖 **AI-Powered Analysis**: Our Gemini AI integration automatically categorizes your expenses - no more manual entry headaches!
- 📱 **SMS Wizardry**: Automagically picks up and processes your bank notifications
- 🎨 **Eye Candy UI**: Gorgeous Material Design 3 interface that adapts to your phone's theme
- 🌙 **Dark Mode Love**: Because counting money at night shouldn't hurt your eyes
- 📊 **Smart Analytics**: Beautiful charts and insights that actually make sense
- ⏰ **Never Miss a Payment**: Smart reminders for your subscriptions and bills

## 🛠️ The Cool Tech Behind It

- 🎭 **Jetpack Compose** - The future of Android UI
- 🧠 **Google Gemini AI** - The brains behind the operation
- 🔥 **Firebase** - Keeping your data safe and synced
- 💾 **Room Database** - Because offline is the new online
- 💉 **Hilt** - Making dependencies a breeze

## 📂 Project Blueprint

```
app/               # Where the magic begins 🎩
├── auth/          # Keeping the bad guys out 🔐
├── billing/       # Money stuff (the irony!) 💰
├── core/          # The heart of the app ❤️
├── gemini/        # AI sorcery 🤖
├── network/       # Internet whisperer 🌐
├── storage/       # Data vault 💾
└── sms/           # Message decoder 📱
```

## 🚀 Let's Get You Started!

### 📋 Shopping List

- Android Studio Hedgehog+ (yes, that's its real name! 🦔)
- JDK 17+ (because we're modern like that ☕)
- Android SDK (API 24+) 📱

### 🛠️ Setup Steps

1. **Clone the Magic** 🧙‍♂️
```bash
git clone <repository-url>
```

2. **Firebase Setup** 🔥
   - Create a Firebase project (it's easier than making instant noodles!)
   - Drop `google-services.json` into the app directory
   - Enable Authentication and Analytics in Firebase Console

3. **Gemini API Magic** 🪄
   - Grab an API key from Google AI Studio
   - Add to `local.properties`:
   ```properties
   GEMINI_API_KEY="your_magical_key_here"
   ```

4. **Launch!** 🚀
```bash
./gradlew assembleDebug
```

## 🤝 Join the Fun!

Got ideas? Found a bug? Want to make this even more awesome? We'd love your help! Here's how:

1. 🍴 Fork it
2. 🌿 Create your feature branch
3. 💾 Commit your changes
4. 🚀 Push to your branch
5. 🎯 Open a Pull Request

Check out [CONTRIBUTING.md](CONTRIBUTING.md) for the full scoop!
