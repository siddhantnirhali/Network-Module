# NetworkModule 🚀

A reusable and modular **Retrofit-based network module** built with **Clean Architecture** and **manual Dependency Injection**, making it easy to plug into any Android project without additional dependencies like Hilt.

---

## ✨ Features

- ✅ Retrofit setup with Gson converter
- ✅ Clean architecture structure
- ✅ Manual Dependency Injection (no Hilt required)
- ✅ Sealed result wrapper using `ApiResult`
- ✅ API response handling with error parsing
- ✅ StateFlow-based ViewModel architecture
- ✅ Example implementation using a free Weather API

---


---

## 🚀 How to Use This Module in Any Project

1. **Clone the repo** or copy the module into your project.
2. Add `NetworkModule` as a module or package in your Android project.
3. Provide your `ApiService` and repository in the `Container` (manual DI).
4. Use the `ViewModel` and call your API function.
5. Observe StateFlow in your `@Composable`.

---




