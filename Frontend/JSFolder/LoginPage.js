async function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Spring Security expects form-encoded data at the loginProcessingUrl
    const res = await fetch('/api/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
      body: `username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`,
      credentials: 'include'   // important: sends/receives the session cookie
    });

    if (!res.ok) {
      document.getElementById('error-msg').style.display = 'block';
      return;
    }

    const data = await res.json();   // { username, role }
    showDashboard(data);
  }

  function showDashboard({ username, role }) {
    document.getElementById('error-msg').style.display = 'none';
    document.getElementById('login-view').style.display = 'none';
    document.getElementById('dashboard').style.display = 'block';

    document.getElementById('welcome-name').textContent = `Welcome, ${username}`;

    const isAdmin = role === 'ROLE_ADMIN';
    const badge = document.getElementById('role-badge');
    badge.textContent = isAdmin ? 'Admin' : 'User';
    badge.className = 'badge ' + (isAdmin ? 'badge-admin' : 'badge-user');

    if (isAdmin) {
      // Fetch admin-only data from a protected endpoint
      fetch('/api/admin/panel', { credentials: 'include' })
        .then(r => r.json())
        .then(d => {
          document.getElementById('admin-panel').style.display = 'block';
          document.getElementById('admin-msg').textContent = d.message;
        });
    }
  }

  async function logout() {
    await fetch('/api/logout', { method: 'POST', credentials: 'include' });
    document.getElementById('login-view').style.display = 'block';
    document.getElementById('dashboard').style.display = 'none';
    document.getElementById('username').value = '';
    document.getElementById('password').value = '';
  }

  // On page load, check if there's already an active session
  fetch('/api/me', { credentials: 'include' })
    .then(r => r.ok ? r.json() : null)
    .then(data => { if (data) showDashboard(data); });