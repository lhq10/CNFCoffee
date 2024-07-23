function toggleForms(event, formId) {
    event.preventDefault();
    document.getElementById('login-form').style.display = formId === 'login-form' ? 'block' : 'none';
    document.getElementById('register-form').style.display = formId === 'register-form' ? 'block' : 'none';
    document.getElementById('forgot-password-form').style.display = formId === 'forgot-password-form' ? 'block' : 'none';
    window.location.hash = formId; // Cập nhật fragment trong URL
}

function showFormFromHash() {
    const hash = window.location.hash;
    if (hash === '#register-form') {
        toggleForms(event, 'register-form');
    } else if (hash === '#forgot-password-form') {
        toggleForms(event, 'forgot-password-form');
    } else {
        toggleForms(event, 'login-form');
    }
}

window.addEventListener('hashchange', showFormFromHash);
window.addEventListener('load', showFormFromHash);
