# UI Internship Project - User Stories Overview

## 📋 Table of Contents
1. [Tools & Technologies](#tools--technologies)
2. [Project Team](#project-team)
3. [User Stories](#user-stories)
    - [🔐 Authentication](#-authentication)
    - [🏠 Home Page Navigation](#-home-page-navigation)
    - [📨 Messaging](#-messaging)
    - [💳 Finance](#-finance)
    - [🎓 Attendance](#-attendance)
    - [👤 Profile](#-profile)
    - [📈 Grading](#-grading)
    - [📑 Assignments](#-assignments)
    - [📅 Calendar](#-calendar)

---

## 🛠️ Tools & Technologies
- Java
- Selenium WebDriver
- TestNG
- Maven
- Git & GitHub
- Jenkins (optional for CI/CD)
- ChromeDriver
- IntelliJ IDEA or Eclipse

---

## User Stories

## 🔐 Authentication
### US-001: Login Feature
- **Scenario Description**: The user logs into the system at `https://test.mersys.io` using valid student credentials.
- **Expected Result**: User is successfully redirected to the home page upon correct login.

---

## 🏠 Home Page Navigation
### US-002: Logo Navigation
- **Scenario Description**: The user clicks the top-left logo after login.
- **Expected Result**: Redirects the user to the home page (`https://techno.study`).

### US-003: Top Nav Functionality
- **Scenario Description**: The user interacts with each top navigation element (Courses, Calendar, etc.).
- **Expected Result**: Corresponding pages or menus open without error.

---

## 📨 Messaging
### US-004: View New Messages
- **Scenario Description**: Hover over Messaging in the Hamburger Menu to view new messages.
- **Expected Result**: New messages are displayed as hoverable items.

### US-005: Send Messages
- **Scenario Description**: Compose and send a new message using the editor from Hamburger Menu > Messaging.
- **Expected Result**: Message is sent and visible in the Outbox with a "Success" confirmation.

### US-006: Delete Messages (Outbox)
- **Scenario Description**: Delete a message from the Outbox with confirmation.
- **Expected Result**: Message is removed and a success confirmation is shown.

### US-007: Restore/Delete Messages (Trash)
- **Scenario Description**: Permanently delete or restore messages from the Trash.
- **Expected Result**: Appropriate success messages shown for restore/delete actions.

---

## 💳 Finance
### US-008 to US-012: Payment & Reporting
- **Scenario Description**: Student makes secure payments, verifies remaining balance, and downloads reports.
- **Expected Result**: Stripe payment succeeds, balance updates, and files are downloadable in Excel/PDF.

---

## 🎓 Attendance
### US-013: Submit Excuse
- **Scenario Description**: Submit an excuse for absence with optional file attachments.
- **Expected Result**: Excuse is saved and confirmation is shown.

---

## 👤 Profile
### US-014: Upload Profile Photo
- **Scenario Description**: Student uploads or changes profile photo.
- **Expected Result**: Profile photo is updated with success confirmation.

### US-015: Change Theme Color
- **Scenario Description**: Select between available theme colors in Profile settings.
- **Expected Result**: Theme changes are reflected immediately and saved.

---

## 📈 Grading
### US-016: View Grades
- **Scenario Description**: Student accesses lecture grades and transcript.
- **Expected Result**: All grade-related pages load and display correct data.

### US-017: Download Grades
- **Scenario Description**: Student downloads grades and transcript as PDFs.
- **Expected Result**: Files open in PDF format and can be saved locally.

---

## 📑 Assignments
### US-018 to US-022: View, Discuss, Submit, Search Assignments
- **Scenario Description**: View assigned tasks, start discussions, upload homework, search/filter tasks.
- **Expected Result**: Task interaction works smoothly with visible feedback and search accuracy.

---

## 📅 Calendar
### US-023 to US-025: Course Calendar
- **Scenario Description**: Track course schedule, handle meeting states, and view past lesson recordings.
- **Expected Result**: Weekly and monthly views load correctly. Past lessons and statuses are accessible.

---

## 👥 Project Team
| Name              | Role                           | Assigned User Stories   |
|-------------------|--------------------------------|-----------------------|
| **Zafer Atakli**  | **Project Lead / QA Engineer** |                       |
|                   |                                |                       |
|                   |                                |                       |
|                   |                                |                       |
|                   |                                |                       |
| ----------------- | ---------------------          | --------------------- |


---
## 👨‍💻 Project Team GitHub

- **[Zafer Ataklı](https://github.com/zaferatakli)**


---
## 📝 License

This project is open-sourced software licensed under the [MIT license](https://opensource.org/licenses/MIT).

