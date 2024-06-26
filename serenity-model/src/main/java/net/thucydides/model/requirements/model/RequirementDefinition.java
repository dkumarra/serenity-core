package net.thucydides.model.requirements.model;

import com.google.common.base.Preconditions;
import net.serenitybdd.model.collect.NewList;
import net.thucydides.model.domain.TestTag;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.*;

public class RequirementDefinition {
    private final Optional<String> title;
    private final Optional<String> id;
    private final Optional<String> cardNumber;
    private final List<String> versionNumbers;
    private final String text;
    private String type;
    private List<TestTag> tags;
    private List<String> scenarios = new ArrayList<>();
    private Map<String, Collection<TestTag>> scenarioTags = new HashMap<>();
    private FeatureBackgroundNarrative background;
    private Map<String, FeatureBackgroundNarrative> ruleBackgrounds = new HashMap<>();

    public RequirementDefinition(Optional<String> title, Optional<String> id, Optional<String> cardNumber, List<String> versionNumbers, String type, String text) {
        Preconditions.checkNotNull(type);
        Preconditions.checkNotNull(text);
        this.title = title;
        this.id = id;
        this.cardNumber = cardNumber;
        this.versionNumbers = versionNumbers;
        this.type = type;
        this.text = text;
        this.tags = new ArrayList<>();
    }

    public RequirementDefinition(Optional<String> title,
                                 Optional<String> id,
                                 Optional<String> cardNumber,
                                 List<String> versionNumbers,
                                 String type,
                                 String text,
                                 List<TestTag> tags) {
        Preconditions.checkNotNull(type);
        Preconditions.checkNotNull(text);
        this.title = title;
        this.id = id;
        this.cardNumber = cardNumber;
        this.versionNumbers = versionNumbers;
        this.type = type;
        this.text = text;
        this.tags = new ArrayList<>(tags);
        this.scenarios = new ArrayList<>();
        this.scenarioTags = new HashMap<>();
    }


    public RequirementDefinition(Optional<String> title,
                                 Optional<String> id,
                                 Optional<String> cardNumber,
                                 List<String> versionNumbers,
                                 String type,
                                 String text,
                                 List<TestTag> tags,
                                 List<String> scenarios,
                                 Map<String, Collection<TestTag>> scenarioTags) {
        Preconditions.checkNotNull(type);
        Preconditions.checkNotNull(text);
        this.title = title;
        this.id = id;
        this.cardNumber = cardNumber;
        this.versionNumbers = versionNumbers;
        this.type = type;
        this.text = text;
        this.tags = new ArrayList<>(tags);
        this.scenarios = scenarios;
        this.scenarioTags = scenarioTags;
    }
    public RequirementDefinition(String type, String text) {
        this(Optional.<String>empty(), Optional.<String>empty(), Optional.<String>empty(), NewList.<String>of(), type, text);
    }

    public Optional<String> getId() {
        return id;
    }

    public Optional<String> getTitle() {
        return title;
    }

    public Optional<String> getCardNumber() {
        return cardNumber;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public List<String> getVersionNumbers() {
        return NewList.copyOf(versionNumbers);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("title", title)
                .append("text", text)
                .append("type", type)
                .toString();
    }

    public List<String> getScenarios() {
        return scenarios;
    }

    public List<TestTag> getTags() {
        return tags;
    }

    public Map<String, Collection<TestTag>> getScenarioTags() {
        return scenarioTags;
    }

    public RequirementDefinition withBackground(FeatureBackgroundNarrative background) {
        this.background = background;
        return this;
    }

    public RequirementDefinition withRuleBackgrounds(Map<String,FeatureBackgroundNarrative> ruleBackgrounds) {
        this.ruleBackgrounds = ruleBackgrounds;
        return this;
    }

    public Optional<FeatureBackgroundNarrative> background() {
        return Optional.ofNullable(background);
    }

    public Optional<FeatureBackgroundNarrative> ruleBackgroundForRule(String ruleName) {
        return Optional.ofNullable(ruleBackgrounds.get(ruleName));
    }

}
