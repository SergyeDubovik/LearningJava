package com.epamTasks.contactTask;

public class Contact {
    private String name;
    ContactInfo phone;
    Email[] emails = new Email[3];
    Social[] socials = new Social[5];

    private class NameContactInfo implements ContactInfo {
        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return name;
        }
    }

    public static class Email implements ContactInfo {
        private final String value;

        public Email(String localPart, String domain) {
            this.value = localPart + "@" + domain;
        }

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    public static class Social implements ContactInfo {
        private final String title;
        private final String value;

        public Social(String title, String id) {
            this.title = title;
            value = id;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return value;
        }
    }


    public Contact(String contactName) {
        this.name = contactName;
    }

    public void rename(String newName) {
        if (newName != null && !newName.isEmpty()) {
            this.name = newName;
        }
    }

    public Email addEmail(String localPart, String domain) {
        Email email = new Email(localPart, domain);
        for (int i = 0; i < emails.length; i++) {
            if (emails[i] == null) {
                emails[i] = email;
                return email;
            }
        }
        return null;
    }


    public Email addEpamEmail(String firstname, String lastname) {

        String localPart = firstname + "_" + lastname;
        Email epamEmail = new Email(localPart, "epam.com") {
            @Override
            public String getTitle() {
                return "Epam Email";
            }
        };
        for (int i = 0; i < emails.length; i++) {
            if (emails[i] == null) {
                emails[i] = epamEmail;
                return epamEmail;
            }
        }
        return null;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if (phone != null) {
            return null;
        }
        phone = new ContactInfo() {
            private final String value = "+" + code + " " + number;

            @Override
            public String getTitle() {
                return "Tel";
            }

            @Override
            public String getValue() {
                return value;
            }
        };
        return phone;
    }

    public Social addTwitter(String twitterId) {
        Social twitter = new Social("Twitter", twitterId);
        for (int i = 0; i < socials.length; i++) {
            if (socials[i] == null) {
                socials[i] = twitter;
                return twitter;
            }
        }
        return null;
    }

    public Social addInstagram(String instagramId) {
        Social instagram = new Social("Instagram", instagramId);
        for (int i = 0; i < socials.length; i++) {
            if (socials[i] == null) {
                socials[i] = instagram;
                return instagram;
            }
        }
        return null;
    }

    public Social addSocialMedia(String title, String id) {
        Social social = new Social(title, id);
        for (int i = 0; i < socials.length; i++) {
            if (socials[i] == null) {
                socials[i] = social;
                return social;
            }
        }
        return null;
    }

    public ContactInfo[] getInfo() {
        int size = 1;
        if (phone != null) {
            size++;
        }
        for (Email email : emails) {
            if (email != null) {
                size++;
            }
        }
        for (Social social : socials) {
            if (social != null) {
                size++;
            }
        }
        ContactInfo[] info = new ContactInfo[size];
        int index = 0;
        info[index++] = new NameContactInfo();
        if (phone != null) {
            info[index++] = phone;
        }
        for (Email email : emails) {
            if (email != null) {
                info[index++] = email;
            }
        }
        for (Social social : socials) {
            if (social != null) {
                info[index++] = social;
            }
        }
        return info;
    }
}
