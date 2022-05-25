# Encryption Vote
The privacy of every voter is guaranteed by a localized differential privacy workflow in the frontend application.
Per question, an user can vote from 1 (excellent) to 5 (very bad). To distinguish the individual vote,
a theoretical coin is thrown in frontend. If head is thrown, the correct result is sent to the backend. If not, a second
coin will be thrown. As again, head sends the original result, tail sends a random result (dependent of the vote mode).

## Vote Modes
On the landing page <b>http://localhost:4200/vote </b> you have 3 options to submit your votes:

<ul>
    <li><b>Save</b>: Default mode. Same as <b>Mode 1</b>, but your vote is only sent one time.</li>
    <li><b>Mode 1</b>: When tail is thrown two times, a random value of the original and its adjacent values is sent.
    For example result 1 -> random of 1 or 2; result 4 -> random of 3, 4 or 5</li>
    <li><b>Mode 2</b>: When tail is thrown two times, a random value except the original is sent.
    For example result 2 -> random of 1, 3, 4 or 5</li>
</ul>

For <b>Mode 1</b> and <b>Mode 2</b>, your vote will be sent ~100 times to the backend. But for each vote, the coins are
thrown independently (this means 100 different votes in best case). This helps you to generate a big set of votes with
only few clicks.

## Installation
<b>Warning</b>: An active internet connection is required for the installation.

### Database
<ol>
    <li>Install a SQL database (MySQL recommended)</li>
    <li>Add a database user with username <b>user</b> and password <b>password</b></li>
    <li>Start the database on your local machine on port 3306 (default port)</li>
    <li>Create the database <b>encryptionvote</b> manually. Tables will be created automatically by the application.</li>
    <li>If you use MySQL, search and open the <b>MySQL Command Line Client</b>. Login with password <b>root</b> and
    enter <b>create database encryptionvote</b>. Click <b>Enter</b>.</li>
</ol>

### Backend Pre-Requisites
<ol>
    <li>Install Java 8 or higher</li>
    <li>Open the project in an IDE (Intellij IDEA recommended). It is recommended to check it out via git.</li>
    <li>Build the Gradle project</li>
    <li>Make sure all dependencies has been loaded via Gradle</li>
</ol>

### Frontend Pre-Requisites
<ol>
    <li>Install NodeJs and NPM via <b>https://nodejs.org/en/download/</b></li>
    <li>Install Angular CLI. Run the command <b>npm install -g @angular/cli</b> in your console</li>
    <li>Go to <b>src/main/kotlin/encryptionvote/frontend</b></li>
    <li>Open the terminal</li>
    <li>Run command <b>npm i --save</b> to load all dependencies</li>
</ol>

## Run Backend Application
Open <b>Application.kt</b> file and run it either in run or debug mode. Make sure the database is running and the table
has been created.

## Run Frontend Application
<ol>
    <li>Go to <b>src/main/kotlin/encryptionvote/frontend</b></li>
    <li>Open the terminal</li>
    <li>Run command <b>ng serve</b></li>
</ol>

## Usage
When backend and frontend is running, open <b>http://localhost:4200/vote </b> in your browser

## License
The ISC jar library which is used in this project was written by Markus Graf.

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
documentation files (the “Software”), to deal in the Software without restriction, including without limitation the
rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

## Credits
<ul>
    <li>Markus Graf</li>
    <li>Christoph Brunner</li>
</ul>